package com.jora.masterservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jora.masterservice.service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;

	@GetMapping("/chkoperator")
	public ResponseEntity<?> chkOperator(@RequestParam int operatorCode) {
		try {
			return ResponseEntity.ok(loginService.chkOperator(operatorCode));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@GetMapping("/loadoperator")
	public ResponseEntity<?> loadOperator() {
		try {
			return ResponseEntity.ok(loginService.loadOperator());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}
