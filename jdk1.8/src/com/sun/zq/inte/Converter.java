package com.sun.zq.inte;

@FunctionalInterface
public interface Converter<F,T> {
	T zhuanhuan(F from);
}
