package com.mycomp.saletax.helper;

import java.util.List;

import com.mycomp.saletax.constants.TaxConstants;
import com.mycomp.saletax.domain.Item;
import com.mycomp.saletax.tax.TaxCalculator;
import com.mycomp.saletax.util.TaxUtils;

public class TaxHelper {

	private TaxCalculator taxCalculator;
	
//	public float getApplicableTax(List<Item> items) throws Exception{
//		float totalTax = 0.00f;
//		float totalPrice = 0.00f;
//		for(Item item:items){			
//			totalPrice+=getPriceInclusiveTax(item);
//			totalTax += getItemTax(item);
//			System.out.println("ID: "+item.getId()+" , Item Cost Including Tax : " +(getPriceInclusiveTax(item)));
//			//System.out.println("TAX ON Item ID "+item.getId()+" is : "+getItemTax(item)); 
//			System.out.println("TOATAL TAX => "+totalTax);
//		}
//		System.out.println("Toatl Tax : " + totalTax);
//		return  totalPrice;
//	}
 
	public double getPriceInclusiveTax(Item item) throws Exception {  

		return (item.getPrice()+taxCalculator.calculateTax(item));
	}
	
	public double getItemTax(Item item) throws Exception {  

		return taxCalculator.calculateTax(item);
	}
	
	public void setTaxCalculator(TaxCalculator taxCalculator) {
		this.taxCalculator = taxCalculator;
	}

}
