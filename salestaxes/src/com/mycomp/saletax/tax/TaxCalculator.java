/**
 * 
 */
package com.mycomp.saletax.tax;

import com.mycomp.saletax.domain.Item;

/**
 * @author akhsh01
 *
 */
public interface TaxCalculator {

	public double calculateTax(Item item)throws Exception;
}
