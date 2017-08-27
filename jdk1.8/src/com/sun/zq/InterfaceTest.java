package com.sun.zq;

public interface InterfaceTest {
	default void defaultMethod(){
		System.out.println("这是jdk1.8默认的接口方法");
	}
	
	static void staticMethod(){
		System.out.println("这是jdk1.8默认的静态方法");
	};
}
