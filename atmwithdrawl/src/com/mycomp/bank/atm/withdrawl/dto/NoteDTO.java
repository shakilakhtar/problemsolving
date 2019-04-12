package com.mycomp.bank.atm.withdrawl.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * This <code>class</code> is a Data Transfer Object 
 * that keeps possible notes combinations for withdrawal amount.
 * 
 * 
 * @author akhsh01(Shakil Akhtar)
 * @version ${Version}
 */
public class NoteDTO {

	/**
	 * An Optimal Table
	 */
	public int optTable[][];
	
	/**
	 * Minimum Notes Array
	 */
	public String minimunNotes[][];
	/**
	 * List of all possible notes series combinations for the withdrawal amount
	 */
	public List<String> allPossibleNotes = new ArrayList<String>();
	
	/**
	 * Withdrawal Amount
	 */
	public int withdrawalAmount;
	
	/**
	 * Denominations Array
	 */
	public int[] denoms;
	
	/**
	 * 
	 * @param amount
	 * @param denoms
	 */
	public NoteDTO(int amount,int[] denoms) { 
		this.withdrawalAmount = amount;
		this.denoms = denoms;
		minimunNotes = new String[denoms.length][amount+1];
		optTable = new int[denoms.length][amount+1];
	}
	
	
	public int[][] getOptTable() {
		return optTable;
	}



	public String[][] getMinimunNotes() {
		return minimunNotes;
	}



	public List<String> getAllPossibleNotes() {
		return allPossibleNotes;
	}

	
	public int getWithdrawalAmount() {
		return withdrawalAmount;
	}


	public int[] getDenoms() {
		return denoms;
	}
}
