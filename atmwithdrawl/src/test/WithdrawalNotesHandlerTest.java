/**
 * 
 */
package test;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.mycomp.bank.atm.withdrawl.WithdrawalNotesHelper;
import com.mycomp.bank.atm.withdrawl.dto.NoteDTO;
import com.mycomp.bank.exception.WithdrawalException;


/**
 * @author akhsh01
 *
 */
public class WithdrawalNotesHandlerTest extends TestCase{
	
	private static WithdrawalNotesHelper withdrawalNotesHelper; 

	@BeforeClass
	public  static void initialize(){
		withdrawalNotesHelper = new WithdrawalNotesHelper();
	}
	
//	@Test
//	public void testFindAllPossibleNotes() throws WithdrawalException{
//		withdrawalNotesHelper = new WithdrawalNotesHelper();
//		int amount=1100;
//		int[] noteSeries = {1000,500,100,50,20,10};
//		NoteDTO noteDTO = withdrawalNotesHelper.findAllPossibleNotes(amount,noteSeries);		
//		Assert.assertNotNull(noteDTO);
//		printAllPossibleNotesCombinations(noteDTO,noteSeries); 
//	}
	
//	@Ignore
//	@Test
//	public void testFindMinimumNotes()throws WithdrawalException{
//		withdrawalNotesHelper = new WithdrawalNotesHelper();
//		int amount=11000;
//		int[] noteSeries = {1000,500,100,50,20,10};
//		NoteDTO noteDTO = withdrawalNotesHelper.findMinimumNotes(amount,noteSeries);		
//		Assert.assertNotNull(noteDTO);
//		String minimumNotesStr = getMinimumNotes(noteDTO,noteSeries);
//		System.out.println(minimumNotesStr);
//	}
//	
//	@Ignore
//	@Test(expected=WithdrawalException.class) 
//	public void testDenominationsNegative(){	
//		withdrawalNotesHelper = new WithdrawalNotesHelper();
//		int amount=1105;
//		int[] noteSeries = {1000,500,100,50,20,15};
//		try{
//		NoteDTO noteDTO = withdrawalNotesHandler.findMinimumNotes(amount,noteSeries);
//		} catch (WithdrawalException wex) { 
//			Assert.assertTrue("This behavior is expected", true); 
//		}
//		finally{
//			
//		}
//		
//	}
	
	@Ignore
	@Test
	public void testGetMinimumNotes()throws WithdrawalException{
		withdrawalNotesHelper = new WithdrawalNotesHelper();
		int amount=110;
		int[] denom = {1,10,20,50,100,500,1000};
		int [] notes  = new int[denom.length];
		int[] noteDTO = withdrawalNotesHelper.getMinimumNotes(amount, notes, denom);		
		Assert.assertNotNull(noteDTO);
		
	      for (int k = 0; k < noteDTO.length; k++ )
		         System.out.println ( (denom[k] < 10 ? " " : "") + denom[k] +
		                              ":  " + notes[k] + " used.");
	}
	
	private void printAllPossibleNotesCombinations(NoteDTO noteDTO,int[] noteSeries) {
		if(noteDTO.allPossibleNotes.size()>0) {
			System.out.println("All possible notes(s) Withdrawal amount=" + noteDTO.withdrawalAmount+ ", Denominations=["+getDemonsAsString(noteSeries)+"]");
			int i=1;
			for(String str: noteDTO.allPossibleNotes) { 
				System.out.println(i + ") " + str);
				i++;
			}
			System.out.println();
		} else {
			System.out.println("No notes for Withdrawal amount="+noteDTO.withdrawalAmount+ ", Denominations=["+getDemonsAsString(noteSeries)+"]");
		}
		
	}
	
	private String getMinimumNotes(NoteDTO noteDTO,int[] noteSeries) {
		int i = noteDTO.minimunNotes.length;
		int j = noteDTO.minimunNotes[0].length;
		String str = "Optimal solution for Withdrawal amount="+noteDTO.withdrawalAmount + ", Denominations=["+getDemonsAsString(noteSeries) + "] is (" 
		+ noteDTO.minimunNotes[i-1][j-1].trim() +")";
		return str;
	}
	
	private String getDemonsAsString(int[] noteSeries){
		StringBuilder sb = new StringBuilder();
		for(int i: noteSeries) {
			sb.append(i + " ");
		}
		return sb.toString();
	}
}
