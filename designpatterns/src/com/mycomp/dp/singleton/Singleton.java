/**
 * 
 */
package com.mycomp.dp.singleton;

/**
 * @author akhsh01
 *
 */
public class Singleton {

	private static Singleton instance;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance() {
		if (instance == null) // 1
			instance = new Singleton(); // 2
		return instance; // 3
	}

	
	// Thread safe singleton method
	public static synchronized Singleton getInstanceThreadSafe() {
		if (instance == null) // 1
			instance = new Singleton(); // 2
		return instance; // 3
	}

	
	public static Singleton getInstanceMinimizeSyncCost() {
		if (instance == null) {
			synchronized (Singleton.class) {
				instance = new Singleton();
			}
		}
		return instance;
	}
	
	public static Singleton getInstanceDoubleCheckLocking() {
		if (instance == null) {
			synchronized (Singleton.class) { // 1
				if (instance == null) // 2
					instance = new Singleton(); // 3
			}
		}
		return instance;
	}


}
