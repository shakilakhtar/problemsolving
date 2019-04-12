/**
 * 
 */
package com.mycomp.dp.singleton;

/**
 * @author akhsh01
 *
 */
public class SingletonDoubleCheckLocking {
	
	private static SingletonDoubleCheckLocking instance;
	
	private SingletonDoubleCheckLocking(){
		
	}

	
	public static SingletonDoubleCheckLocking getInstacne(){
		
		if(instance==null){
			
			synchronized(SingletonDoubleCheckLocking.class){
				
				if(instance==null){
					instance = new SingletonDoubleCheckLocking();
					
				}
			}
			
		}
		return instance;
	}
}
