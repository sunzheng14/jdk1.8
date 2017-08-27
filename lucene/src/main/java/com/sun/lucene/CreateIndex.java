package com.sun.lucene;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class CreateIndex {
	
	public void createIndex(){
		IndexWriter writer = null;
		try {
			//1.创建directory
			//Directory indexDir = new RAMDirectory();//创建在内存中
			Directory indexDir = FSDirectory.open(new File("F:\\test\\index01"));//创建在硬盘中
			//2.创建IndexWriter
			IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35));
			writer = new IndexWriter(indexDir, iwc);
			//3.创建document
			Document doc = null;
			//4.为document添加Field
			File f = new File("F:\\test\\lucene");
			for(File file : f.listFiles()){
				doc = new Document();
				doc.add(new Field("content",new FileReader(file)));
				doc.add(new Field("filename",file.getName(),Field.Store.YES,Field.Index.NOT_ANALYZED));
				doc.add(new Field("path",file.getAbsolutePath(),Field.Store.YES,Field.Index.NOT_ANALYZED));
				//doc.add(new Field("name","sunzheng",Field.Store.YES,Field.Index.NOT_ANALYZED));
				//5.通过indexWriter添加文档到索引中
				writer.addDocument(doc);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (CorruptIndexException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void searcher(){
		try {
			//1.创建Directory
			Directory indexDir = FSDirectory.open(new File("F:\\test\\index01"));
			//2.创建IndexReader
			IndexReader reader = IndexReader.open(indexDir);
			//3.根据IndexReader创建IndexSearcher
			IndexSearcher searcher = new IndexSearcher(reader);
			//4. 创建搜索的Query
			//创建parse来确定要搜索的内容，第二个参数表示搜索的域
			QueryParser parse = new QueryParser(Version.LUCENE_35, "content", new StandardAnalyzer(Version.LUCENE_35));
			
			Query query = parse.parse("java");
			//5.根据searcher搜索并且返回TopDocs
			TopDocs tds = searcher.search(query, 10);
			//6.根据TopDocs获取scoreDoc对象
			ScoreDoc[] sds =tds.scoreDocs;
			for(ScoreDoc sd : sds){
				//7.根据seacher和scoreDoc对象获取具体的Document对象
				Document d = searcher.doc(sd.doc);
				//8.根据document对象获取需要的值
				System.out.println(d.get("filename")+"["+d.get("path") +"]");
				System.out.println(d.get("name"));
			}
			//9.关闭reader
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}


}
