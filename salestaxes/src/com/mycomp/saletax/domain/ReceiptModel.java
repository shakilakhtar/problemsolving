/**
 * 
 */
package com.mycomp.saletax.domain;

import java.math.BigDecimal;

/**
 * A model that is used to print description of purchased items.
 * We can also use this model as a DTO to share payment information to 
 * other systems.
 * 
 * @author shakil.akhtar
 * @version ${version}
 */
public class ReceiptModel {

    private int quantity;
    private String name;
    private BigDecimal totalCost;
    private BigDecimal salesTax;

    public ReceiptModel(int quantity, String name, double salesTax, double totalCost) {
            this.quantity = quantity;
            this.name = name;
            this.salesTax = new BigDecimal(Double.toString(salesTax)).setScale(2,
                            BigDecimal.ROUND_HALF_EVEN);
            this.totalCost = new BigDecimal(Double.toString(totalCost)).setScale(2,
                            BigDecimal.ROUND_HALF_EVEN);
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public BigDecimal getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(BigDecimal salesTax) {
		this.salesTax = salesTax;
	}

	
}
