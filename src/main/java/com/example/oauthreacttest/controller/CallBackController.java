package com.example.oauthreacttest.controller;

import com.example.oauthreacttest.service.GitHubSocialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CallBackController {

	private final GitHubSocialService gitHubSocialService;

	@GetMapping("/login/oauth2/code/github")
	@ResponseBody
	public void getCallbackGithub(@PathParam("code") String code ,HttpServletResponse httpServletResponse){
		System.out.println("code="+code);
		System.out.println("access="+httpServletResponse.getHeader("Authorization"));
	}

	@GetMapping ("/callback/github")
	public ResponseEntity<?> getLogin(@PathParam("code") String code) throws IOException {
		log.info("git code="+code);
		String accessToken = gitHubSocialService.getAccessToken(code);
		return new ResponseEntity<>(accessToken, HttpStatus.OK);
	}
}
