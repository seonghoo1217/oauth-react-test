package com.example.oauthreacttest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class CallBackController {

	@GetMapping("/login/oauth2/code/github")
	@ResponseBody
	public void getCallbackGithub(HttpServletResponse httpServletResponse){
		System.out.println(httpServletResponse.getStatus());
		System.out.println(httpServletResponse.getHeader("access_token"));
	}

	@GetMapping("/login/oauth/authorize")
	public void getLogin(HttpServletResponse httpServletResponse){
		System.out.println("What?");
		System.out.println(httpServletResponse.getStatus());
	}
}
