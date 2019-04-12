/**
 * 
 */
package com.mycomp.saletax;

import java.util.ArrayList;
import java.util.List;

import com.mycomp.saletax.constants.ItemType;
import com.mycomp.saletax.domain.Item;
import com.mycomp.saletax.helper.ReceiptHelper;
import com.mycomp.saletax.helper.TaxHelper;
import com.mycomp.saletax.scart.Cart;
import com.mycomp.saletax.scart.ShoppingCart;
import com.mycomp.saletax.tax.ServiceTaxCalculator;
import com.mycomp.saletax.tax.TaxCalculator;

/**
 * @author akhsh01
 *
 */
public class MainTest {

	public static void main(String[] args) throws Exception {
		
		ReceiptHelper receiptHelper = new ReceiptHelper();
		Cart cart = new ShoppingCart("Shakil Akhtar", "Reliance Mart", "20-10-2011");
		TaxHelper taxHelper = new TaxHelper();
		TaxCalculator taxCalculator = new ServiceTaxCalculator();
		taxHelper.setTaxCalculator(taxCalculator);
		
		receiptHelper.setTaxHelper(taxHelper);
		receiptHelper.setCart(cart);
		
		for(Item item: getItemList3()){
			cart.addItem(item);
		}
		receiptHelper.generateReceipt(cart);
		receiptHelper.print();
		//float tax = taxHelper.getApplicableTax(getItemList3());
		//System.out.println("Applicable Tax : "+tax);
	}
	
	
	public static List<Item> getItemList1(){
		
		List<Item> items = new ArrayList<Item>();
		
		Item item1 = new Item();
		item1.setId(1L);
		item1.setQuantity(1);
		item1.setName("Book");
		item1.setItemType(ItemType.BOOK);
		item1.setDescription("book");
		item1.setPrice(12.49f);
		item1.setExempted(true);
		item1.setImported(false);
		
		Item item2 = new Item();
		item2.setId(2L);
		item2.setQuantity(1);
		item2.setName("music CD");
		item2.setItemType(ItemType.OTHERS);
		item2.setDescription("music CD");
		item2.setPrice(14.99f);
		item2.setExempted(false);
		item2.setImported(false);
		
		Item item3 = new Item();
		item3.setId(3L);
		item3.setQuantity(1);
		item3.setName("chocolate bar");
		item3.setItemType(ItemType.FOOD);
		item3.setDescription("chocolate bar");
		item3.setPrice(0.85f);
		item3.setExempted(true);
		item3.setImported(false);
		
		//add items to list
		items.add(item1);
		items.add(item2);
		items.add(item3);
		   
		return items;
	}

	public static List<Item> getItemList2(){
		
		List<Item> items = new ArrayList<Item>();
		
		Item item1 = new Item();
		item1.setId(1L);
		item1.setQuantity(1);
		item1.setName("imported box of chocolates ");
		item1.setItemType(ItemType.FOOD);
		item1.setDescription("imported box of chocolates ");
		item1.setPrice(10.00f);
		item1.setExempted(true);
		item1.setImported(true);
		
		Item item2 = new Item();
		item2.setId(2L);
		item2.setQuantity(1);
		item2.setName("imported bottle of perfume");
		item2.setItemType(ItemType.OTHERS);
		item2.setDescription("imported bottle of perfume");
		item2.setPrice(47.50f);
		item2.setExempted(false);
		item2.setImported(true);
		
		
		//1 imported box of chocolates at 10.00
		//1 imported bottle of perfume at 47.50

		
		//add items to list
		items.add(item1);
		items.add(item2);
		   
		return items;
	}
	
	public static List<Item> getItemList3(){
		
		List<Item> items = new ArrayList<Item>();
		
		
		Item item1 = new Item();
		item1.setId(1L);
		item1.setQuantity(1);
		item1.setName("imported bottle of perfume at");
		item1.setItemType(ItemType.OTHERS);
		item1.setDescription("imported bottle of perfume at");
		item1.setPrice(27.99f);
		item1.setExempted(false);
		item1.setImported(true);
		
		Item item2 = new Item();
		item2.setId(2L);
		item2.setQuantity(1);
		item2.setName("bottle of perfume");
		item2.setItemType(ItemType.OTHERS);
		item2.setDescription("bottle of perfume");
		item2.setPrice(18.99f);
		item2.setExempted(false);
		item2.setImported(false);
		
		Item item3 = new Item();
		item3.setId(3L);
		item3.setQuantity(1);
		item3.setName("packet of headache pills");
		item3.setItemType(ItemType.MEDICAL);
		item3.setDescription("packet of headache pills");
		item3.setPrice(9.75f);
		item3.setExempted(true);
		item3.setImported(false);
		
		Item item4 = new Item();
		item4.setId(4L);
		item4.setQuantity(1);
		item4.setName("box of imported chocolates");
		item4.setItemType(ItemType.FOOD);
		item4.setDescription("box of imported chocolates"); 
		item4.setPrice(11.25f);
		item4.setExempted(true);
		item4.setImported(true);
		
//		    Input 3:
//			1 imported bottle of perfume at 27.99
//			1 bottle of perfume at 18.99
//
//			1 packet of headache pills at 9.75
//			1 box of imported chocolates at 11.25

		
		//add items to list
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
	
		return items;
	}

}
