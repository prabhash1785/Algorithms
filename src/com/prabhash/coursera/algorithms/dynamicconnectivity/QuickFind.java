/*
 * Union Find Algorithm.
 * 
 * @author Prabhash Rathore
 */
package com.prabhash.coursera.algorithms.dynamicconnectivity;

/**
 * Union Find algorithm to determine if two objects are connected or not. Also connect two unconnected elements.
 * 
 * @author prrathore
 *
 */
public class QuickFind {
	
	private int[] list;
	
	public QuickFind() {
		this(10);
	}
	
	public QuickFind(int n) {
		list = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = i;
		}
	}
	
	/**
	 * Determine if two elements are connected.
	 * 
	 * Time Complexity: O(1)
	 * 
	 * @param p
	 * @param q
	 * @return boolean
	 */
	public boolean isConnected(int p, int q) {
		return list[p] == list[q];
	}
	
	/**
	 * Connect two non-connected elements. While connecting two elements, we also need to make rest of the elements in first 
	 * component gets updated to the value of second element so that we know all these elements are part of one component.
	 * 
	 * Time Complexity: O(n) for each union operation.
	 * 
	 * So for n union operations, time complexity with quadratic O(n ^ 2)
	 * 
	 * @param p
	 * @param q
	 */
	public void createUnion(int p, int q) {
		
		if(isConnected(p, q)) {
			System.out.println(p + " and " + q + " are already connected!!");
			return;
		}
		
		int pId = list[p];
		int qId = list[q];
		
		for(int i = 0; i < list.length; i++) {
			if(list[i] == pId) {
				list[i] = qId;
			}
		}
		
	}

	public static void main(String[] args) {
		
		QuickFind quickFind = new QuickFind();
		
		System.out.println("Here is the generated array: ");
		for(int i = 0; i < quickFind.list.length; i++) {
			System.out.print(quickFind.list[i] + " ");
		}
		
		//test above union find algorithm
		System.out.println("\n" + quickFind.isConnected(2, 7));
		quickFind.createUnion(2, 7);
		System.out.println("\n" + quickFind.isConnected(2, 7));
		quickFind.createUnion(2, 7);

	}

}
