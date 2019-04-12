/**
 * 
 */
package com.mycomp.bank.atm.utils;

/**
 * A utility <code>class</code> for ATM
 * 
 * @author akhsh01
 *
 */
public class ATMUtils {
	
	public static boolean validateDenominations(int[] denoms,int multipleValue){
		boolean success =false;
		for(int denomValue: denoms){
			if(denomValue%multipleValue==0){
				success=true;
			}
			else{
				success=false;
				break;
			}
		}
		return success;
	}
	
	public static boolean validateWithdrawalAmount(int amount,int minimumNoteValue){
		boolean success =false;	
		if (amount > 0) {
			if (amount % minimumNoteValue == 0) {
				success = true;
			} else {
				success = false;
			}
		}
		return success;
	}
}
