/**
 * 
 */
package com.mycomp.saletax.scart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mycomp.saletax.domain.Item;

/**
 * @author akhsh01
 *
 */
public class ShoppingCart implements Cart{


    private String customerName;
    private String cashierName;
    private String date;
    
    private List<Item> cart = null;//new ArrayList<Item>();
    
    public ShoppingCart(String customerName, String cashierName, String date) {
        this.customerName = customerName;
        this.cashierName = cashierName;
        this.date = date;
        cart = new ArrayList<Item>();

}

    
	@Override
	public void addItem(Item item) throws Exception {
		cart.add(item);
	}

	@Override
	public void removeItem(Item item) throws Exception {
		cart.remove(item);
	}

	@Override
	public int getItemCount() throws Exception {
		
		return cart.size();
	}

	@Override
	public void getItem(Item item) throws Exception {
		cart.remove(item);
	}

	@Override
	public void empty() {
		cart.clear();
	}

	@Override
	public Iterator<Item> iterator() {
		return cart.iterator();
	}


}
