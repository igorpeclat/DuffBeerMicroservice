package com.duff.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class BeerStyleExistException.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason="Style of Beer already exist. Try another one, please!")
public class BeerStyleExistException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3062974177842079333L;

	/**
	 * Instantiates a new beer style exist exception.
	 */
	public BeerStyleExistException() {
		super();
	}

	/**
	 * Instantiates a new beer style exist exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param params the params
	 */
	public BeerStyleExistException(String message, Throwable cause, Object... params) {
		super(String.format(message, params), cause);
	}

	/**
	 * Instantiates a new beer style exist exception.
	 *
	 * @param message the message
	 * @param params the params
	 */
	public BeerStyleExistException(String message, Object... params) {
		super(String.format(message, params));
	}

	/**
	 * Instantiates a new beer style exist exception.
	 *
	 * @param cause the cause
	 */
	public BeerStyleExistException(Throwable cause) {
		super(cause);
	}
}