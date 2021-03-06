package com.sun.zq.streamPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreamTest {
	static void parallelTest(){
		int max = 10000000;
		List<String> list = new ArrayList<String>(max);
		for(int i = 0;i<max; i++){
			UUID uuid = UUID.randomUUID();
			list.add(uuid.toString());
		}
		
		//streamSorted(list);
		parallelStreamSorted(list);
		
	}
	
	static void streamSorted(List<String> list){
		long t0 = System.nanoTime();
		long count = list.stream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1-t0);
		System.out.println(String.format("stream sorted took: %d ms", millis));
	}
	
	static void parallelStreamSorted(List<String> list){
		long t0 = System.nanoTime();
		long count = list.parallelStream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1-t0);
		System.out.println(String.format("stream sorted took: %d ms", millis));
	}
}
