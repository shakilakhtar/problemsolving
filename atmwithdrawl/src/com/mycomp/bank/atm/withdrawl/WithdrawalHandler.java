/**
 * 
 */
package com.mycomp.bank.atm.withdrawl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.mycomp.bank.exception.WithdrawalException;

/**
 * A Withdrawal Handler that will manage user withdrawal from
 * underlying database system.I am assuming here this <code>class</code>
 * is an Is a Relationship design with database operations processor.
 * If database operation processor is utilizing transaction it will
 * utilize locking mechanism provided by used Transaction API
 * (like,JTA or if any Messaging is used ex. JOTM).
 * In my case i am taking handling for parallel amount 
 * update with thread locks.
 * 
 * @author akhsh01
 * @version ${Version}
 */
public class WithdrawalHandler {
 
	private static Lock lock = new ReentrantLock();
	
	private WithdrawalNotesHelper withdrawalNotesHelper;
	
	//Denomination 
	private int[] denoms;
	
	//I am taking this as old java style, here we can utilize IOC
	//dependency injection mechanism to inject WithdrawalNotesHelper
	public WithdrawalHandler(WithdrawalNotesHelper withdrawalNotesHelper){
		this.withdrawalNotesHelper=withdrawalNotesHelper;
	}
	
	/**
	 * Method will take care of withdrawal for use account
	 * @param accountNo user account number
	 * @param withdrawalAmount
	 */
	public void processWithdrawal(int accountNo,int withdrawalAmount){
		//Validate User 
		//calculate notes availability and minimum notes 
		//using WithdrawalNotesHelper
		try{
		
		lock.lock();
		withdrawalNotesHelper.findMinimumNotes(withdrawalAmount, denoms);
		//update database after successful withdrawal
			
		} catch (WithdrawalException wex) { 
			// TODO Replace stack trace with logging 
			wex.printStackTrace();
		}
		finally{
			lock.unlock();
		}
		
	}
	
	/**
	 * This method will load denomination from a properties file,
	 * for more we can consider a Rule Engine if we are using any 
	 * in application.
	 * 
	 * @return
	 */
	public int[] getDenominations(){
		
		int[] noteSeries = {1000,500,100,50,20,10};
		
		return noteSeries;
	}
	
}
