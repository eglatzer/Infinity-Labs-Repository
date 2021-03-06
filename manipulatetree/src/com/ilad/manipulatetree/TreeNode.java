package com.ilad.manipulatetree;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	
	// Constructor
	public TreeNode(int data_) {
		data = data_;
	}
	
	// Getter
	public int getData() {
		return data;
	}
	
	public int findNumOfNonLeafNodes() {
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		int count = 0;
		TreeNode node;
		
		list.add(this);
		
		while(!list.isEmpty()) {
			node = list.pop();
			
			if(null != node && (null != node.left || null != node.right)) {
				++count;
				list.add(node.left);
				list.add(node.right);
			}
		}
		
		return count;
	}
	
	public ArrayList<ArrayList<Integer>> findSum(int sum) {
		ArrayList<ArrayList<Integer>> arrayOfArrays = new ArrayList<>();
		ArrayList<Integer> array = new ArrayList<>();
		return findSum(sum, arrayOfArrays, array);
	}
	
	private ArrayList<ArrayList<Integer>> findSum
		(int sum, ArrayList<ArrayList<Integer>> arrayOfArrays, ArrayList<Integer> array) {		
		array.add(data);
			
		if(null == left && null == right) {
			if(sum == data) {
				arrayOfArrays.add(array);
			}
				
			return arrayOfArrays;
		}
			
		ArrayList<Integer> rightPath = new ArrayList<>(array.subList(0, array.size()));
			
		if(null != left) {
			left.findSum(sum - data, arrayOfArrays, array);	
		}
			
		if(null != right) {
			right.findSum(sum - data, arrayOfArrays, rightPath);
		}
		
		return arrayOfArrays;		
	}
	
	public static void main(String[] args) {
		final int SUM = 22;
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		System.out.println
			("Number of Non Leaf Nodes in root: " + root.findNumOfNonLeafNodes());
		
		System.out.println("Sum of " + SUM + " in root: " + root.findSum(SUM));
	}
}
