package com.mycomp;

public class TryReturn {

	public static void main(String[] args) {
		System.out.println(tryIt());
	}
	
	public static int tryIt(){
		int x=100; 
		try{
			
			throwExcep();
			return x;
			
		}
		catch(Exception ex){
			x=200;
			return x;
		}
		finally{
			x=300;
			return x;
		}
	}
	
	static void throwExcep()throws Exception{
		
		throw new MyException();
	}
}
