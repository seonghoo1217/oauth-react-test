package com.example.oauthreacttest.controller;

import com.example.oauthreacttest.service.GitHubSocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class CallBackController {

	private final GitHubSocialService gitHubSocialService;

	/*@GetMapping("/login/oauth2/code/github")
	@ResponseBody
	public void getCallbackGithub(@RequestParam("code")String code ,HttpServletResponse httpServletResponse){
		System.out.println("code="+code);
		System.out.println("access="+httpServletResponse.getHeader("Authorization"));
	}*/

	@PostMapping ("/callback/github")
	public ResponseEntity<?> getLogin(@RequestParam("code") String code) throws IOException {
		String accessToken = gitHubSocialService.getAccessToken(code);
		return new ResponseEntity<>(accessToken, HttpStatus.OK);
	}
}
