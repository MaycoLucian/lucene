package lucene;

import org.junit.Test;
import java.io.FileInputStream;

import java.io.FileReader;

import java.io.IOException;

 

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;

import org.apache.lucene.document.Field;

import org.apache.lucene.index.IndexWriter;

import org.apache.lucene.store.Directory;

import org.apache.lucene.store.FSDirectory;

public class LuceneTest {

	@Test
	public void criarDiretorio() {
		Document document = new Document();

		try {

			FileInputStream arquivo = new FileInputStream("/home/dir lucene");

			Directory directory = FSDirectory.getDirectory("/home/dir lucene", true);

			Analyzer analyzer = new StandardAnalyzer();

			IndexWriter writer = new IndexWriter(directory, analyzer, true);

			document.add(new Field("arquivo", "/home/arquivo.txt", Field.Store.YES, Field.Index.NO));

			document.add(new Field("conteudo", new FileReader(arquivo.getFD())));

			writer.addDocument(document);

			writer.close();

			arquivo.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
