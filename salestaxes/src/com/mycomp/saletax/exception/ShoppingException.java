/**
 * 
 */
package com.mycomp.saletax.exception;

/**
 * @author akhsh01
 * 
 */
public  class ShoppingException extends ApplicationException {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2083546426776965081L;

	public ShoppingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ShoppingException(String msg) {
		super(msg);
	}

	public ShoppingException(Throwable cause) {
		super(cause);
	}

}
