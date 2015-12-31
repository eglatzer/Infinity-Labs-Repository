package com.ilad.singlylinkedlist;

public class MainTest {
	public static void main(String args[]) {
		System.out.println("Hello world!");
		
		SinglyList list = new SinglyList();
		Object data1 = 1;
		Object data2 = 2;
		System.out.println("is_empty = " + list.isEmpty());
		System.out.println("count = " + list.count());
		list.pushFront(data1);
		System.out.println(list.peekFront());
		list.pushFront(data2);
		System.out.println(list.peekFront());
		System.out.println("is_empty = " + list.isEmpty());
		System.out.println("count = " + list.count());
		System.out.println("find num2 = " + list.find(data2).getData());
		System.out.println("find next num2 = " + list.find(data2).goNext().getData());
		list.popFront();
		System.out.println("find num2 = " + list.find(data2));
		System.out.println(list.peekFront());
	}
}
