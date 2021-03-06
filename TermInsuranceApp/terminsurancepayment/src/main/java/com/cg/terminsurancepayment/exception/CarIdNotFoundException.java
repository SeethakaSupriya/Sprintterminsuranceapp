package com.cg.terminsurancepayment.exception;

/** The CarIdNotFoundException layer provides customized Exceptions
 * 
 * @author G5
 * 
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarIdNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "CarId entered is  Not found";

	public CarIdNotFoundException(final String MESSAGE) {
		super(MESSAGE);
	}
}
