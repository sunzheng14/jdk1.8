package com.sun.zq;

public interface InterfaceTest {
	default void defaultMethod(){
		System.out.println("����jdk1.8Ĭ�ϵĽӿڷ���");
	}
	
	static void staticMethod(){
		System.out.println("����jdk1.8Ĭ�ϵľ�̬����");
	};
}
