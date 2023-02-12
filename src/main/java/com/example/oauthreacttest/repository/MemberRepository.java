package com.example.oauthreacttest.repository;

import com.example.oauthreacttest.domain.Member;
import com.example.oauthreacttest.domain.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByOauthId(String id);
	Optional<Member> findByEmail(String email);
	Optional<Member> findByRefreshToken(String refreshToken);

	Optional<Member> findBySocialTypeAndOauthId(SocialType socialType, String oauthId);

}