/**
 * 
 */
package com.mycomp.saletax.exception;

/**
 * @author akhsh01
 *
 */
public abstract class ApplicationException extends Exception{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -5682904749746392047L;

	public ApplicationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ApplicationException(String msg) {
		super(msg);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}
}
