/**
 * 
 */
package com.mycomp.saletax.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mycomp.saletax.domain.Item;
import com.mycomp.saletax.domain.ReceiptModel;
import com.mycomp.saletax.scart.Cart;
import com.mycomp.saletax.util.TaxUtils;

/**
 * A Receipt Helper to be used for shopping receipt generation.
 * This <code>class</code> print item details,item cost and applicable tax
 * on item with total cost of purchased items and service tax.We can extend this 
 * <code>class</code> to some discount applicable for product sales etc.
 * 
 * @author akhsh01
 * @version ${version}
 *
 */
public class ReceiptHelper {

	private double totalPrice;
	private double totalTax;
    private List<ReceiptModel> receiptItems; 

	private TaxHelper taxHelper; 
	
	private Cart cart;

	
	public void generateReceipt(Cart cart) throws Exception{	
		receiptItems = new ArrayList<ReceiptModel>(); 
		Iterator<Item> iterator = cart.iterator();
		while(iterator.hasNext()){			
			Item item = iterator.next();
//			System.out.println("ID: "+item.getId()+" , Item Cost Including Tax : " 
//					+TaxUtils.scaledPrice(taxHelper.getPriceInclusiveTax(item))); 
			
			//System.out.println("TAX ON Item ID "+item.getId()+" is : "+getItemTax(item)); 
			//System.out.println("TOATAL TAX => "+totalTax);
			receiptItems.add(new ReceiptModel(item.getQuantity(),item.getName(),
					taxHelper.getItemTax(item),taxHelper.getPriceInclusiveTax(item)));
			totalPrice+=taxHelper.getPriceInclusiveTax(item);
			totalTax += taxHelper.getItemTax(item);
		}	
	}
	
    /**
     * Method used by any printer to print the receipt
     * */
    public void print() {
          //  Iterator<ReceiptModel> iterator = receiptItems.iterator();
            for (ReceiptModel receiptItem:receiptItems) {
                   // ReceiptModel item = iterator.next();
                    System.out.println(receiptItem.getQuantity() + " " + receiptItem.getName() + " :" + receiptItem.getTotalCost());
            }

            System.out.println("\nSales Taxes:\t" + TaxUtils.scaledPrice(totalTax));
            System.out.println("Total:\t" + TaxUtils.scaledPrice(totalPrice));
            cart.empty();
    }


	public double getTotalPrice(){
		return this.totalPrice;
	}
	
	public double getTotalTax(){
		return this.totalTax;
	}

	public void setTaxHelper(TaxHelper taxhelper) {
		this.taxHelper = taxhelper;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
