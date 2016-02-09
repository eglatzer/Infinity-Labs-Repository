package com.ilad.singlylinkedlist;

public class GenericSinglyList<E> {
private GenericNode m_head;
	
	public class GenericListIterator {
		// Constructor
		public GenericListIterator(GenericNode node_) {
			m_node = node_;
		}
		
		private GenericNode m_node;
		
		public E getData() {
			if(m_node == null)
			{
				return null;
			}
			return m_node.m_data;
		}
		
		public GenericListIterator goNext() {
			return new GenericListIterator(m_head.m_next);
		}
	}
	
	private class GenericNode {
		// Constructor
		public GenericNode(E data_, GenericNode next_) {
			m_data = data_;
			m_next = next_;
		}
		
		private E m_data;
		private GenericNode m_next;
	}
	
	public void pushFront(E data_) {
		m_head = new GenericNode(data_, m_head);
	}
	
	public void popFront() {
		if(m_head != null)
			m_head = m_head.m_next;
	}
	
	public E peekFront() {
		if(m_head == null)
			return null;
		return m_head.m_data;
	}
	
	public boolean isEmpty() {
		return (m_head == null);
	}
	
	public long count() {
		long counter = 0;
		GenericNode curr = m_head;
		while(curr != null)
		{
			++counter;
			curr = curr.m_next;
		}
		return counter;
	}
	
	public GenericListIterator find(E data_) {
		GenericNode curr = m_head;
		while(curr != null)
		{
			if(curr.m_data.equals(data_))
			{
				return new GenericListIterator(curr);
			}
			curr = curr.m_next;
		}
		return null;
	}
}
