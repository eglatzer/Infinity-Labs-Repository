package com.ilad.pair;

import java.util.Random;

public class Pair<K, V extends Comparable<V>> {
	private K key;
	private V value;
	
	// Constructor
	public Pair(K key_, V value_) {
		key = key_;
		value = value_;
	}

	// Getters and Setters
	public K getKey() {
		return key;
	}

	public void setKey(K key_) {
		key = key_;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value_) {
		value = value_;
	}

	// Equals Method
	public boolean equals(Pair<K, V> obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		if(key == null) {
			if(obj.key != null)
				return false;
		} else if(!key.equals(obj.key))
			return false;
		if(value == null) {
			if(obj.value != null)
				return false;
		} else if(!value.equals(obj.value))
			return false;
		return true;
	}
	
	// CompareTo Method
	public double compareTo(Pair<K, V> obj) {
		return value.compareTo(obj.value);
	}

	// HashCode Method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	
	// ToString Method
	@Override
	public String toString() {
		return "pair: key = " + key + ", value = " + value;
	}
	
	// Swap Method
	public static <R extends Comparable<R>, T extends Comparable<T>> Pair<T, R> swap(Pair<R, T> obj) {
		return new Pair<T, R>(obj.value, obj.key);
	}
	
	// Of Method (Factory Method)
	public static <R, T extends Comparable<T>> Pair<R, T> of(R key, T value) {
		return new Pair<R, T>(key, value);
	}
	
	// Minmax Method
	public static <R extends Comparable<R>, T extends Comparable<T>> Pair<T, T> minmax(T[] obj) {
		T min = obj[0];
		T max = obj[0];
		
		for(int i = 1; i < obj.length; ++i) {
			if(0 > obj[i].compareTo(min)) {
				min = obj[i];
			}
			else if(0 < obj[i].compareTo(max)) {
				max = obj[i];
			}
		}
		
		return new Pair<T, T>(min, max);
	}
	
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("Hello", 5);
		System.out.println(pair.toString());
		pair.setKey("Bye bye");
		pair.setValue(6);
		System.out.println(pair.toString());
		System.out.println("key = " + pair.getKey());
		System.out.println("value = " + pair.getValue());
		Pair<String, Integer> pair2 = pair;
		Pair<String, Integer> pair3 = new Pair<>("Bye bye", 6);
		if(!pair.equals(pair) || !pair.equals(pair2) || !pair.equals(pair3)) {
			System.out.println("Something's wrong in equals() method! <110>");
		}
		pair3.setKey("Thanks");
		if(pair.equals(pair3)) {
			System.out.println("Something's wrong in equals() method! <114>");
		}
		pair3.setValue(7);
		if(pair.equals(pair3)) {
			System.out.println("Something's wrong in equals() method! <118>");
		}
		pair3.setKey("Bye bye");
		if(pair.equals(pair3)) {
			System.out.println("Something's wrong in equals() method! <122>");
		}
		pair3.setValue(6);
		if(!pair.equals(pair3)) {
			System.out.println("Something's wrong in equals() method! <126>");
		}
		Pair<Double, Double> pairDouble1 = new Pair<>(2.5, 3.4);
		Pair<Double, Double> pairDouble2 = new Pair<>(2.7, 3.4);
		Pair<Double, Double> pairDouble3 = new Pair<>(2.7, 3.2);
		if(0 != pairDouble1.compareTo(pairDouble2)) {
			System.out.println("Something's wrong in compareTo() method! <132>");
		}
		if(0 >= pairDouble1.compareTo(pairDouble3)) {
			System.out.println("Something's wrong in compareTo() method! <135>");
		}
		if(0 <= pairDouble3.compareTo(pairDouble1)) {
			System.out.println("Something's wrong in compareTo() method! <138>");
		}
		System.out.println("hashCode of pairDouble1 = " + pairDouble1.hashCode());
		Pair<Double, Double> pairSwapped = Pair.swap(pairDouble1);
		System.out.println("pairDouble1, " + pairDouble1.toString());
		System.out.println("pairSwapped, " + pairSwapped.toString());
		int ind = 123_456_788;
		long l = 123_456_789;
		Pair<Integer, Long> pairFactorred = Pair.of(ind, l);
		System.out.println("pairFactorred, " + pairFactorred.toString());
		Integer[] array = new Integer[15];
		Random random = new Random();
		for(int i = 0; i < 15; ++i) {
			array[i] = new Integer(random.nextInt(1000));
			System.out.println("array[" + i + "] = " + array[i]);
		}
		Pair<Integer, Integer> minmax = Pair.minmax(array);
		System.out.println("minmax, " + minmax.toString());
	}
}
