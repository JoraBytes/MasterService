package com.jora.masterservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jora.masterservice.common.ErrorHandler;
import com.jora.masterservice.service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;

	private final Logger log = LogManager.getLogger(getClass());

	@GetMapping("/chkoperator")
	public ResponseEntity<?> chkOperator(@RequestParam int operatorCode) {
		try {
			return ResponseEntity.ok(loginService.chkOperator(operatorCode));
		} catch (Exception e) {
			log.error(ErrorHandler.errorTraceForLogger(e));
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}
