package com.example.oauthreacttest.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String oauthId;

	private String name;

	private String email;

	private String imageUrl;

	@Enumerated(EnumType.STRING)
	private SocialType socialType;

	@Enumerated(EnumType.STRING)
	private Role role;

	private String refreshToken;

}