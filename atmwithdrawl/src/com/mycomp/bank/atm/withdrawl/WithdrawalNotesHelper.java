/**
 * 
 */
package com.mycomp.bank.atm.withdrawl;

import static com.mycomp.bank.atm.utils.ATMUtils.validateDenominations;
import static com.mycomp.bank.atm.utils.ATMUtils.validateWithdrawalAmount;

import com.mycomp.bank.atm.withdrawl.dto.NoteDTO;
import com.mycomp.bank.exception.WithdrawalException;

/**
 * This <code>class</code> is responsible finding number of required notes
 * in withdrawal amount.It finds possible combinations of notes and 
 * also provide minimum number of notes with optimal solution algorithm.
 * This problem is an example of Greedy and Dynamic memorization
 * combinations
 * 
 * @author akhsh01
 * @version ${Version}
 */
public class WithdrawalNotesHelper {

	/**
	 * Method will find all possible combination of denomination
	 * for the amount. 
	 * 
	 * @param withdrawalAmount a numeric withdrawal amount 
	 * @param denoms an Integer array of Notes series in ATM
	 * @return a Note DTO(Data Transfer Object)
	 * @throws WithdrawalException if fails to get Notes or deviations from conditions 
	 */
	public NoteDTO findAllPossibleNotes(int withdrawalAmount, int[] denoms) throws WithdrawalException{
		//We Should validate one more condition that account is having sufficient 
		//amount in his account.This is a Database fetch no need to bother about 
		//multithreading here.
		if(!validateWithdrawalAmount(withdrawalAmount,10)){
			throw new WithdrawalException("Amount should be multiple of 10");
		}
		if(!validateDenominations(denoms,10)){
			throw new WithdrawalException("All Denominations is not multiple of 10");
		}
		NoteDTO noteDTO = new NoteDTO(withdrawalAmount, denoms);
		String tempSoln = new String();
		findAllNotesCombinations(tempSoln, 0, withdrawalAmount, noteDTO);
		return noteDTO;
		
	}
	
	/**
	 * Method will return optimum solution i.e minimum number of notes 
	 * to be given for withdrawal amount.
	 *  
	 * @param withdrawalAmount a numeric withdrawal amount 
	 * @param denoms an Integer array of Notes series in ATM
	 * @return a Note DTO having information of calculations for notes 
	 * @throws WithdrawalException if fails to get minimum Notes or deviations from conditions 
	 */
	public NoteDTO findMinimumNotes(int withdrawalAmount, int[] denoms) throws WithdrawalException{ 
		if(!validateWithdrawalAmount(withdrawalAmount,10)){
			throw new WithdrawalException("Amount should be multiple of 10");
		}
		if(!validateDenominations(denoms,10)){
			throw new WithdrawalException("Denomination is not multiple of 10");
		}
		NoteDTO noteDTO = new NoteDTO(withdrawalAmount,denoms);
		StringBuilder sb = new StringBuilder();	
		
		for(int i=0; i<noteDTO.optTable[0].length ; i++) {
			noteDTO.optTable[0][i] = i;
			noteDTO.minimunNotes[0][i] = sb.toString();
			sb.append(denoms[0]+" ");
		}

		for(int i=1 ; i<denoms.length ; i++) {
			for(int j=0; j<withdrawalAmount+1 ; j++) {
				int value = j;
				int amountWithPrevDenomiation = noteDTO.optTable[i-1][j]; 
				int ix = (value) - denoms[i];
				if( ix>=0 && (denoms[i] <= value )) {
					int x2 = denoms[i] + noteDTO.optTable[i][ix];
					if(x2 <= withdrawalAmount && (1+noteDTO.optTable[i][ix] < amountWithPrevDenomiation)) {
						String temp = noteDTO.minimunNotes[i][ix] + denoms[i] + " ";
						noteDTO.minimunNotes[i][j] = temp;
						noteDTO.optTable[i][j] = 1 + noteDTO.optTable[i][ix];
					} else {
						noteDTO.minimunNotes[i][j] = noteDTO.minimunNotes[i-1][j]+ " ";
						noteDTO.optTable[i][j] = amountWithPrevDenomiation;
					}
				} else {
					noteDTO.minimunNotes[i][j] = noteDTO.minimunNotes[i-1][j];
					noteDTO.optTable[i][j] = amountWithPrevDenomiation;
				}
			}
		}
		return noteDTO;
	}
	
	private void findAllNotesCombinations(String tsoln, int startIx, int remainingAmount, NoteDTO noteDTO) {  
		for (int i = startIx; i < noteDTO.denoms.length; i++) { 
			int temp = remainingAmount - noteDTO.denoms[i];
			String tempSoln = tsoln + "" + noteDTO.denoms[i] + ",";
			if (temp < 0) {
				break;
			}
			if (temp == 0) {
				// reached the withdrawal amount hence quit from the loop
				noteDTO.allPossibleNotes.add(tempSoln);
				break;
			} else {
				// amount not reached, try the solution recursively with the
				// current denomination as the start point.
				findAllNotesCombinations(tempSoln, i, temp, noteDTO);
			}
		}
	}

	
	   public  int [] getMinimumNotes(int amount, int [] notes, int [] denoms) {    
		      int n = denoms.length-1;
		      int [][] c = new int[n+1][amount+1];     // Zero-filled
		      int j, k;
		      // Table generation --- dynamic programming portion
		      // c[0][k] remains unchanged at zero as a sentinel row.
		         for ( k = 0; k <= amount; k++ ){
		            c[0][k] = 0;
		         }
		         for ( j = 1; j <= n; j++ ){ 
		        	 notes[j] = 0;
		            c[j][0] = 0;   // Insure column 0 holds zeroes.

		            for ( k = 1; k <= amount; k++ )
		               if ( j == 1 ){
		                  if ( k < denoms[j] ){
		                     c[j][k] = Integer.MAX_VALUE;
		                  }
		                  else{
		                     c[j][k] = 1 + c[j][k-denoms[j]];
		                  }
		               }
		               else{
		                  if ( k < denoms[j] ){
		                     c[j][k] = c[j-1][k];
		                  }
		                  else{
		                     c[j][k] = Math.min(c[j-1][k], 1 + c[j][k-denoms[j]]);
		                  }
		              
		              }
		         }
		         j = n;  k = amount;
		      // From the table, get the coins used --- greedy portion
		         while ( k > 0 && j > 0 ){
		            if ( c[j][k] == c[j-1][k] ){   // Denom. not used
		               j = j - 1;
		            }
		            else {                        // Denom. WAS used
		             ++notes[j];  k = k - denoms[j];  
		             }
		         }
		         
		         return notes;
		         
		      }

}
