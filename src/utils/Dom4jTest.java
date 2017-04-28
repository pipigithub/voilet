package utils;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Dom4jTest {
	
	@Test
	public void getDocument() throws Exception{
		SAXReader reader = new SAXReader();
		Document document=reader.read("src\\utils\\books.xml");
	    System.out.println(document);
	}
	
	@Test
	public void getText() throws Exception {
		SAXReader reader = new SAXReader();
		Document document=reader.read("src\\utils\\books.xml");
	    Element books=document.getRootElement();
	    List<Element> bookList  = books.elements();
	    
	    for(Element e:bookList){
	    	Element name = e.element("name");
	    	Element author = e.element("author");
	    	Element price = e.element("price");
	    	System.out.println(name.getText()+"="+author.getText()+"="+price.getText());
	    }
	}
	
	@Test
	public void update() throws Exception{
		SAXReader reader = new SAXReader();
		Document document=reader.read("src\\utils\\books.xml");
	    Element books=document.getRootElement();
	    
	    Element book = (Element)books.elements().get(0);
	    Element name = book.element("name");
	    name.setText("fj");
	    
	    OutputFormat format = OutputFormat.createPrettyPrint();
	    format.setEncoding("utf-8");
	    XMLWriter writer = new XMLWriter(new FileOutputStream("src\\utils\\books.xml"),format);
	    writer.write(document); 
	    writer.close();
	}
	
	@Test
	public void delete() throws Exception{
		SAXReader reader = new SAXReader();
		Document document=reader.read("src\\utils\\books.xml");
	    Element books=document.getRootElement();
	    Element book =(Element) books.elements().get(0);
	    books.remove(book);
	    
	    OutputFormat format = OutputFormat.createPrettyPrint();
	    format.setEncoding("utf-8");
	    XMLWriter writer = new XMLWriter(new FileOutputStream("src\\utils\\books.xml"),format);
	    writer.write(document); 
	    writer.close();
	    
	}
	
	@Test
	public void add() throws Exception{
		
		Document document=Dom4jUtils.getDocument();
	    Element books=document.getRootElement();
	    Element book=books.addElement("book");
	    Element name = book.addElement("name");
	    Element author = book.addElement("author");
	    Element price = book.addElement("price");
	    name.setText("收到甲方");
	    author.setText("多少分能进你");
	    price.setText("55");
	
	    Dom4jUtils.write(document);
	    
	}
	
	// XPath是为了快速定位到标签s
	@Test
	public void testXPath(){
		Document document = Dom4jUtils.getDocument();
		List<Element> bookList = document.selectNodes("//book");
		System.out.println(bookList.size());
	}

}
