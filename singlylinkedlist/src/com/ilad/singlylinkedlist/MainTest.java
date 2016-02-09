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
		
		System.out.println();
		System.out.println("Hello world!");
		
		GenericSinglyList<String> gList = new GenericSinglyList<String>();
		String s1 = "Hi";
		String s2 = "Bye";
		System.out.println("is_empty = " + gList.isEmpty());
		System.out.println("count = " + gList.count());
		gList.pushFront(s1);
		System.out.println(gList.peekFront());
		gList.pushFront(s2);
		System.out.println(gList.peekFront());
		System.out.println("is_empty = " + gList.isEmpty());
		System.out.println("count = " + gList.count());
		System.out.println("find s2 = " + gList.find(s2).getData());
		System.out.println("find next s2 = " + gList.find(s2).goNext().getData());
		gList.popFront();
		System.out.println("find s2 = " + gList.find(s2));
		System.out.println(gList.peekFront());
	}
}
