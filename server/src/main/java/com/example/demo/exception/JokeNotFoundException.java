package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="JokeRequest Not Found")
public class JokeNotFoundException extends RuntimeException{
public JokeNotFoundException(String errorMessage) {
	super(errorMessage);
}
@Override
public String getMessage() {
	return super.getMessage();
}
}
