package com.sun.lucene;

public class Test {
	@org.junit.Test
	public void createIndexTest(){
		CreateIndex ci = new CreateIndex();
		ci.createIndex();
	}
	
	@org.junit.Test
	public void testSearch(){
		CreateIndex ci = new CreateIndex();
		ci.searcher();
	}
}
