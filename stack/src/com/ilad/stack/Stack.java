package com.ilad.stack;

public class Stack {
	protected class Node {
		Object data;
		Node next;
		//Constructors
		protected Node() {
			data = null;
			next = null;
		}
		protected Node(Object data_) {
			data = data_;
			next = null;
		}
		protected Node(Node next_) {
			data = null;
			next = next_;
		}
		protected Node(Object data_, Node next_) {
			data = data_;
			next = next_;
		}
		//Getters (data + next)
		protected Object getData() {
			return data;
		}
		protected Node getNext() {
			return next;
		}
		//Setters (data + next)
		protected void setData(Object data_) {
			data = data_;
		}
		protected void setNext(Node next_) {
			next = next_;
		}
	}
	private Node head;
	//Constructor
	public Stack() {
		head = null;
	}
	public void push(Object data_) {
		Node addedNode = new Node(data_, head);
		head = addedNode;
	}
	public Object pop() {
		if(null == head) {
			return head;
		}
		Object poppedNode = head.data;
		head = head.next;
		return poppedNode;
	}
	public Object peek() {
		if(null == head) {
			return head;
		}
		return head.data;
	}
}
