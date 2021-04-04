package by.geller.xmlproject.parsers.sax;

import by.geller.xmlproject.Banks;
import by.geller.xmlproject.exception.EmptyException;
import by.geller.xmlproject.parsers.dom.DOMParser;
import by.geller.xmlproject.parsers.sax.handler.AdvancedXMLHandler;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class SaxParserTest {
    @Test
    public void parser() throws EmptyException, ParserConfigurationException, SAXException {
        String filePath = "src/main/java/by/geller/xmlproject/xmlFiles/Bank.xml";
        SaxParser saxParser = new SaxParser(filePath);
        ArrayList<Banks> arrayList = AdvancedXMLHandler.arrayList;

        for (Banks b : arrayList) {
            System.out.println(b);
        }

    }
}
