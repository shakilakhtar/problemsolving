/**
 * 
 */
package com.mycomp.saletax.domain;

import java.io.Serializable;

import com.mycomp.saletax.constants.ItemType;
import com.mycomp.saletax.util.TaxUtils;

/**
 * An Item domain <code>class</code> contains item definition 
 * and applicable tax details 
 * 
 * @author shakil.akhtar
 * @version ${version}
 */
public class Item implements Serializable{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 2069184858788929746L;
    
	private Long id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	private ItemType itemType;
	private boolean isExempted;
	private boolean isImported;
	private double taxAmount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	public boolean isExempted() {
		return isExempted;
	}
	public void setExempted(boolean isExempted) {
		this.isExempted = isExempted;
	}
	public boolean isImported() {
		return isImported;
	}
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	

}
