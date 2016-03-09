package com;

import java.util.LinkedList;
import java.util.List;

public class MainClass {
	
	public static void main(String[] args) {
		List<String> l = new LinkedList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add(1,"z");
		System.out.println(l);
		
	}
	
}
