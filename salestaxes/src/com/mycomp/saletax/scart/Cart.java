/**
 * 
 */
package com.mycomp.saletax.scart;

import java.util.Iterator;

import com.mycomp.saletax.domain.Item;

/**
 * @author akhsh01
 * 
 */
public interface Cart {

	public void addItem(Item item) throws Exception;

	public void removeItem(Item item) throws Exception;

	public int getItemCount() throws Exception;

	public void getItem(Item item) throws Exception;

	public Iterator<Item> iterator();
	
	public void empty();
}
