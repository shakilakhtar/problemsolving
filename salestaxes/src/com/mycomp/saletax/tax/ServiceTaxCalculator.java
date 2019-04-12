/**
 * 
 */
package com.mycomp.saletax.tax;

import static com.mycomp.saletax.constants.TaxConstants.BASIC_FACTOR;
import static com.mycomp.saletax.constants.TaxConstants.IMPORTED_FACTOR;

import com.mycomp.saletax.domain.Item;
import com.mycomp.saletax.util.TaxUtils;

public class ServiceTaxCalculator implements TaxCalculator {

	@Override
	public double calculateTax(Item item) throws Exception {
		double serviceTax=0.00f;
		if (item.isExempted()&& !item.isImported()) { 
			// No tax applicable for item
		}
		if (!item.isExempted()) {
			serviceTax += TaxUtils.roundOffTaxValue((item.getPrice())* (BASIC_FACTOR));
		}
		if(item.isImported()){
			serviceTax+= TaxUtils.roundOffTaxValue((item.getPrice())* (IMPORTED_FACTOR));
		}
		else{
			//do other tax calculations if applicable 
		}

		return serviceTax;
	}

}
