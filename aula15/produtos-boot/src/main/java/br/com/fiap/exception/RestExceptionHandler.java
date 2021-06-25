package br.com.fiap.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
	
	private static final String UNEXPECTED_ERROR = "Um erro inesperado aconteceu, contate com o suporte";
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseException handException(HttpServletRequest request, Exception exception) {
		return new ResponseException(request,UNEXPECTED_ERROR, exception.getMessage());
	}
}

