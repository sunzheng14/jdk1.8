package com.sun.zq;

import java.util.Comparator;


public class MyComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		String a = (String)o1;
		String b = (String)o2;
		return b.compareTo(a);
	}

}
