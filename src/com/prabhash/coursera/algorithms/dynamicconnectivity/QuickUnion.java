/*
 * Quick Union - Algorithm for Dynamic Connectivity Problems
 * 
 */

package com.prabhash.coursera.algorithms.dynamicconnectivity;

/**
 * This is one of the algorithm for Dynamic Connectivity problems. Using this algorithm you can find if two components are
 * connected or not. Also it will let you connect two unconnected sub-components.
 * 
 *  QuickUnion is more efficient at Union operation compared to QuickFind algorithm.
 * 
 * @author Prabhash Rathore
 *
 */
public class QuickUnion {
	
	private int[] list;
	
	public QuickUnion() {
		this(10);
	}
	
	public QuickUnion(int n) {
		list = new int[n];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = i;
		}
	}
	
	/**
	 * This method will find root element for any other element in this list
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param num
	 * @return num
	 */
	private int findRoot(int num) {
		
		//make sure num exists in the list
		if(num >= list.length) {
			System.out.println(num + " isn't a valid number in the list");
			return -1;
		}
		
		while(num != list[num]) {
			num = list[num];
		}
		
		return num;
	}
	
	/**
	 * Check if the root of two given elements are same. If they are equal then they must be connected.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param p
	 * @param q
	 * @return boolean
	 */
	public boolean isConnected(int p, int q) {
		
		return findRoot(p) == findRoot(q);
	}
	
	/**
	 * Create union of two non-connected elements.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param p
	 * @param q
	 */
	public void createUnion(int p, int q) {
		if(isConnected(p, q)) {
			System.out.println(p + " and " + q + " are already connected!!");
			return;
		}
		
		int rootOfP = findRoot(p);
		int rootOfQ = findRoot(q);
		
		list[rootOfP] = rootOfQ;
	}

	/**
	 * Test above algorithm.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		QuickUnion quickUnion = new QuickUnion();
		
		System.out.println(quickUnion.isConnected(4, 7));
		
		quickUnion.createUnion(4, 7);
		
		System.out.println(quickUnion.isConnected(4, 7));
		

	}

}
