package com.ilad.sorting;

import java.lang.reflect.Array;

public class GenericArray {
	public <E> E[] getArrayInstance(E[] array) {
		Class<?> arrayClass = array.getClass().getComponentType();
		@SuppressWarnings("unchecked")
		E[] newArray = (E[])Array.newInstance(arrayClass, array.length);
		return newArray;
	}
		
		public <E> E[] getArrayInstance(E[] array, int length) {
			Class<?> arrayClass = array.getClass().getComponentType();
			@SuppressWarnings("unchecked")
			E[] newArray = (E[])Array.newInstance(arrayClass, length);
			return newArray;
	}
}
