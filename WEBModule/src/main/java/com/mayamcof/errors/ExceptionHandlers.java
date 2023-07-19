package com.mayamcof.errors;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mayamcof.exception.AuthenticationException;
import com.mayamcof.exception.UniqueException;

@RestControllerAdvice
public class ExceptionHandlers {
	
	@ExceptionHandler(UniqueException.class)
	public ResponseEntity<String> hanlerUniqueException(UniqueException ex) throws JSONException{
		JSONObject response = new JSONObject();
		response.put("title", "Unique");
		response.put("status",  HttpStatus.UNAUTHORIZED.value());
		response.put("message", ex.getMessage());
		response.put("errorCode", ex.getErrorCode());
		response.put("champ", ex.getChamp());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response.toString());
		
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String>handlerAuthontificationException(AuthenticationException ex) throws JSONException{
		
		JSONObject response = new JSONObject();
		response.put("title", "Authentication");
		response.put("status",  HttpStatus.UNAUTHORIZED.value());
		response.put("message", ex.getMessage());
		response.put("errorCode", ex.getErrorCode());
		response.put("champ", ex.getChamp());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response.toString());
		
	}
}
