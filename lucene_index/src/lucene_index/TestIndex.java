package lucene_index;

import org.junit.Test;

public class TestIndex {
	@Test
	public void testIndex(){
		IndexUtil util = new IndexUtil();
		util.index();
	}
}
