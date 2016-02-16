package com.ilad.printobject;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintObject {
	public static<T> void print(T obj) {
		Class<?> printtheObject = obj.getClass();
		
		System.out.println(printtheObject);
		
		if(printtheObject.isPrimitive() || printtheObject.isEnum()) {
			System.out.println(obj);
			return;
		}
		if(printtheObject.isArray()) {
			int size = Array.getLength(obj);
			for(int i = 0; i < size; ++i) {
				print(Array.get(obj, i));
			}
			return;
		}

		if(obj instanceof Number ||
		   obj instanceof CharSequence ||
		   obj instanceof Boolean ||
		   obj instanceof Character ||
		   obj instanceof Map ||
		   obj instanceof List ||
		   obj instanceof Set) {
			System.out.println(obj);
			return;
		}
		
		Field[] fields = printtheObject.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field.getName());
			try {
				print(field.get(obj));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
