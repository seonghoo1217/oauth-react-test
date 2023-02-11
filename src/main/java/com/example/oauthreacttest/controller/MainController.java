package com.example.oauthreacttest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@PostMapping("/healthcheck")
	public String getPong(){
		return "pong";
	}
}
