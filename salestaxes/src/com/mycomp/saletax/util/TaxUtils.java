/**
 * 
 */
package com.mycomp.saletax.util;

import static com.mycomp.saletax.constants.TaxConstants.ROUNDOFF_FACTOR;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.mycomp.saletax.constants.TaxConstants;


/**
 * @author akhsh01
 *
 */
public class TaxUtils {

	
	
	public static double roundOffTaxValue(double tax){
		//return (float) Math.ceil(tax/ROUNDOFF_FACTOR)*ROUNDOFF_FACTOR;
        BigDecimal bdTax = new BigDecimal(Math.ceil(tax/ROUNDOFF_FACTOR)*ROUNDOFF_FACTOR);
        double scaledTaxAmount = bdTax.setScale(TaxConstants.REQUIRED_DECIMAL_PLACES,
                BigDecimal.ROUND_HALF_UP).doubleValue();
//		  float p = (float)Math.pow(10,2);
//		  tax = tax * p;
//		  float tmp = Math.round(tax);
//		  return (float)tmp/p;
         return scaledTaxAmount;

	}

    private double roundUpSalesTax(double totalSalesTaxForThisProduct, int nearestFiveCents) {
        BigDecimal bigDecimalRepresentation = new BigDecimal(
                        Double.toString(totalSalesTaxForThisProduct));
        double scaledNumber = bigDecimalRepresentation.setScale(TaxConstants.REQUIRED_DECIMAL_PLACES,
                        BigDecimal.ROUND_HALF_UP).doubleValue() * 100;
        double resolution = scaledNumber % TaxConstants.NEAREST_N_CENTS;
        if (resolution != 0) {
                scaledNumber += TaxConstants.NEAREST_N_CENTS - resolution;
        }
        return scaledNumber / 100;
}
	
	public static BigDecimal scaledPrice(double price){
		return new BigDecimal(Double.toString(price)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

}
