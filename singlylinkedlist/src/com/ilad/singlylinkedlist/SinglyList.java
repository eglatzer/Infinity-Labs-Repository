package com.ilad.singlylinkedlist;

public class SinglyList {
	private Node m_head;
	public class ListIterator {
		private Node m_node;
		public Object getData() {
			if(m_node == null)
			{
				return null;
			}
			return m_node.m_data;
		}
		public ListIterator(Node node_) {
			m_node = node_;
		}
		public ListIterator goNext() {
			assert(m_head == null);
			return new ListIterator(m_head.m_next);
		}
	}
	
	private class Node {
		private Object m_data;
		private Node m_next;
		public Node(Object data_, Node next_) {
			m_data = data_;
			m_next = next_;
		}
	}
	
	public void pushFront(Object data_) {
		m_head = new Node(data_, m_head);
	}
	
	public void popFront() {
		if(m_head != null)
			m_head = m_head.m_next;
	}
	
	public Object peekFront() {
		if(m_head == null)
			return null;
		return m_head.m_data;
	}
	
	public boolean isEmpty() {
		return (m_head == null);
	}
	
	public long count() {
		long counter = 0;
		Node curr = m_head;
		while(curr != null)
		{
			++counter;
			curr = curr.m_next;
		}
		return counter;
	}
	public ListIterator find(Object data_) {
		Node curr = m_head;
		while(curr != null)
		{
			if(curr.m_data.equals(data_))
			{
				return new ListIterator(curr);
			}
			curr = curr.m_next;
		}
		return null;
	}
}