package com.sun.zq;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientMain {

	public static void main(String[] args) {
		/*InterfaceTest.staticMethod();
		InterfaceTest it = new InterfaceTestImpl();
		it.defaultMethod();*/
		
		
		List<String> list = Arrays.asList("peter","tom","boy","girl");
		/*Collections.sort(list, new MyComparator());*/
		/*Collections.sort(list, (String a,String b)->{
			return b.compareTo(a);
		});*/
		/*Collections.sort(list, (a,b)->{
			return b.compareTo(a);
		});*/
		Collections.sort(list, (a,b)->b.compareTo(a));
		
		for(String str : list){
			System.out.println(str);
		}
		
		list.forEach((str) -> System.out.println(str));
		System.out.println("============");
		list.forEach(System.out::println);
		System.out.println("=============");
		mapTest();
		
	}
	
	static void mapTest(){
		Map<String,String> map = new HashMap<>();
		map.put("a", "aa");
		map.put("b", "bb");
		map.put("c", "cc");
		map.put("d", "dd");
		map.put("e", "ee");
		
		map.forEach((key,value)-> System.out.println(value));
		System.out.println("map==========");
		for(int i=0;i<10;i++){
			map.putIfAbsent(i+"", "val"+i);
		}
		map.remove("d", "dd");
		System.out.println(map.get("d"));
		System.out.println(map.getOrDefault("e", "bucunzai"));
		
		map.forEach((key,value)-> System.out.println(value));
	}

}
