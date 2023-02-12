package com.example.oauthreacttest.dto.oauth.userinfo;

import java.util.Map;

public class GithubOAuth2UserInfo extends OAuth2UserInfo {

	public GithubOAuth2UserInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		System.out.println("attributes="+attributes);
		return (String) attributes.get("node_id");
	}

	@Override
	public String getNickname() {
		return (String) attributes.get("login");
	}

	@Override
	public String getImageUrl() {
		return (String) attributes.get("avatar_url");
	}

	@Override
	public String getEmail() {
		return (String) attributes.get("email");
	}


}