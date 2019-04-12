/**
 * 
 */
package com.mycomp.saletax.exception;


/**
 * @author akhsh01
 *
 */
public class ItemNotFound extends ShoppingException {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4436040380979284558L;

	public ItemNotFound(String msg, Throwable cause) {
		super(msg, cause);
	}
}
