package com.example.oauthreacttest.config;

import com.example.oauthreacttest.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity // spring security 설정을 활성화시켜주는 어노테이션
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService oAuth2UserService;
	private final OAuth2SuccessHandler successHandler;
	private final TokenService tokenService;


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() // h2 console 접속을 위해
				.httpBasic().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers("/token/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.oauth2Login().loginPage("/token/expired") // OAuth2 로그인 설정 시작점
				.redirectionEndpoint()
				.baseUri("http://localhost:3000/oauth2/callback")
				.and()
				.successHandler(successHandler)
				.userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때 설정 담당
				.userService(oAuth2UserService); // OAuth2 로그인 성공 시, 후작업을 진행할 UserService 인터페이스 구현체 등록
		http.addFilterBefore(new JwtAuthFilter(tokenService), UsernamePasswordAuthenticationFilter.class);
	}
}