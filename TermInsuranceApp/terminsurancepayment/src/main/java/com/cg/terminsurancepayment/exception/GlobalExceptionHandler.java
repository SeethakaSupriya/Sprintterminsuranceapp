package com.cg.terminsurancepayment.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),"Enter valid data", request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DuplicatePaymentException.class)
	public ResponseEntity<?> duplicatePaymentException(DuplicatePaymentException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PaymentIdNotFoundException.class)
	public ResponseEntity<?> paymentNotFoundException(PaymentIdNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CarIdNotFoundException.class)
	public ResponseEntity<?> CarIdNotFoundException(CarIdNotFoundException ex,WebRequest request){
	ErrorDetails errorDetails=new ErrorDetails(new Date(),ex.getMessage(),"CarIdFoundException");
	return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);

	}
}
