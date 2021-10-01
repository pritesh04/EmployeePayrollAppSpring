package com.bridgelabs.advice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabs.model.ResponseDto;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeeControllerAdvice {
	
	private static final String message="Exception while processing REST request";
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception)
	{
		log.error("Ïnvalid Date format",exception);
		ResponseDto res=new ResponseDto(message,"Should have date in dd MM yyyy");
		return new ResponseEntity<ResponseDto>(res,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDto> HandleMethodArgumentNotValidException(EmployeePayrollException exception)
	{
		ResponseDto res=new ResponseDto("Exception while processing REST request",exception.getMessage());
		return new ResponseEntity<ResponseDto>(res,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDto> HandleMethodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
		List<String> errMsg=errorList.stream().map(objErr->objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDto res=new ResponseDto("Exception while processing REST request",errMsg);
		return new ResponseEntity<ResponseDto>(res,HttpStatus.BAD_REQUEST);
		
	}
}
