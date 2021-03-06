package com.cts.mars;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
//import org.junit.Assert;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;
import org.xml.sax.SAXException;

public class XmlDiff extends XMLTestCase  {

	public XmlDiff() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SAXException, IOException, FileNotFoundException  {

		FileReader fr1 = null;
		FileReader fr2 = null;
		int countofdifferences = 0;
		try {
	            fr1 = new FileReader("C:\\Work\\1.xml");
	            fr2 = new FileReader("C:\\Work\\2.xml");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
        
		//String xml1 = "<open><id>123</id></open>";
		//String xml2 = "<open><id>1234</id></open>";
 
		//XML comparison configs
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreComments(true);
		XMLUnit.setIgnoreAttributeOrder(true);

		//assertXMLEquals(xml1, xml2);
		
		try {
		Diff diff = new Diff(fr1,fr2);
		
		System.out.println("Similar? " + diff.similar());
        System.out.println("Identical? " + diff.identical());
        
        DetailedDiff detDiff = new DetailedDiff(diff);
        List differences = detDiff.getAllDifferences();
        for (Object object : differences) {
            Difference difference = (Difference)object;
            System.out.println("***********************");
            System.out.println(difference);
            System.out.println("***********************");
        }
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
	}

}
