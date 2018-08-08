package com.duff.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class BeerNotFoundException.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Style of Beer doesn't exist. Try another one, please!")
public class BeerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 3062974177842079333L;

	/**
	 * Instantiates a new beer not found exception.
	 */
	public BeerNotFoundException() {
		super();
	}
	
	/**
	 * Instantiates a new beer not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param params the params
	 */
	public BeerNotFoundException(String message, Throwable cause, Object... params) {
		super(String.format(message, params), cause);
	}

	/**
	 * Instantiates a new beer not found exception.
	 *
	 * @param message the message
	 * @param params the params
	 */
	public BeerNotFoundException(String message, Object... params) {
		super(String.format(message, params));
	}

	/**
	 * Instantiates a new beer not found exception.
	 *
	 * @param cause the cause
	 */
	public BeerNotFoundException(Throwable cause) {
		super(cause);
	}

}
