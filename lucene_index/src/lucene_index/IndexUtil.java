package lucene_index;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;

public class IndexUtil {
	private String[] ids ={"1","2","3","4","5","6"};
	private String[] emails = {"aa@qq.com","bb@sina.com","cc@cc.org","dd@jd.edu","ee@zh.edu","ff@hh.edu"};
	private String[] contents = {
			"welcome to visited the space","hello boy","my name is cc","I like football and I like basketball too","I like movie and swim","I like football"};
	
	private int[] attachs = {2,3,1,4,5,5};
	private String[] names = {"zhangsan","lisi","john","jetty","mike","jake"};
	
	private Directory directory = null;
	
	public IndexUtil(){
		try {
			directory = FSDirectory.open(new File("f:/test/index02"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void index(){
		IndexWriter writer = null;
		try {
			writer = new IndexWriter(directory,new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35)));
			Document doc = null;
			for(int i= 0;i<ids.length;i++){
				doc = new Document();
				doc.add(new Field("id",ids[i],Field.Store.YES,Field.Index.NOT_ANALYZED_NO_NORMS));
				doc.add(new Field("email",emails[i],Field.Store.YES,Field.Index.NOT_ANALYZED));
				doc.add(new Field("content",contents[i],Field.Store.NO,Field.Index.ANALYZED));
				doc.add(new Field("name",names[i],Field.Store.YES,Field.Index.NOT_ANALYZED_NO_NORMS));
				writer.addDocument(doc);
			}
			
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(writer!=null){
					writer.close();
				}
			} catch (CorruptIndexException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
