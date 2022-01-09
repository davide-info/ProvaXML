import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class TestMain {
private static Document getDocument(String path)  {
	Document document=null;
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	try {
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		document = docBuilder.parse(new File(path));
		//System.out.println("DOCUMEN);
		
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
	return document;
	
	
}
private static void processNodes(Document document) {
	//document.getDocumentElement().normalize();
	document.getDocumentElement().normalize();
	System.out.println("ELEMENTO RADICE " + document.getDocumentElement()+"\n");
	NodeList list = document.getElementsByTagName("*");
	
for(int i=0; i<list.getLength(); i++) {
	Node node = list.item(i);
	NamedNodeMap map=node.getAttributes();

	
	System.out.println(String.valueOf(i+1) + " " + node.getNodeName() + " " + node.getTextContent());
	for(int j=0; j<map.getLength(); j++) {
		Node value = map.item(j);
		
		System.out.println("NODO " +String.valueOf(i+1) + " "+ node.getNodeName() + " VALORE "+value);
	}
}


}
private static void testFile() {
	String path="./src/class.xml";
	BufferedReader reader=null;
	String str="";
	try {
		 reader = new BufferedReader(new FileReader(path));
		 while(true) {
			 str =reader.readLine();
			 if(str ==null) break;
			 System.out.println(str);
		 }
		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(reader!=null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

	public static void main(String[] args) {
		//String path ="./src/class.xml";
		testFile();

	Query query =QueryFactory.create();
	//query.

	}

}
