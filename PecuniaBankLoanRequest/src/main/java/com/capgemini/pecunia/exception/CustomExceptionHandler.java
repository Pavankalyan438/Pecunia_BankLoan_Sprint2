package com.capgemini.pecunia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
// annotation provided by Spring allowing you to write global code that can be
// applied to a wide range of controllers
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(BankAccountNotFound.class)
	public ResponseEntity<String> myMessage(BankAccountNotFound c) {
		return new ResponseEntity<String>(c.getMessage(), HttpStatus.OK);
	}
}