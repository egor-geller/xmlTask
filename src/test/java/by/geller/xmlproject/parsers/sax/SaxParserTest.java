package by.geller.xmlproject.parsers.sax;

import by.geller.xmlproject.entity.Banks;
import by.geller.xmlproject.parsers.sax.handler.AdvancedXMLHandler;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class SaxParserTest {
    @Test
    public void parser() throws ParserConfigurationException, SAXException, IOException {
        String filePath = "src/main/java/by/geller/xmlproject/xmlFiles/Bank.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        AdvancedXMLHandler advancedXMLHandler = new AdvancedXMLHandler();
        saxParser.parse(filePath, advancedXMLHandler);

        Set<Banks> arrayList = AdvancedXMLHandler.arrayList;

        for (Banks b : arrayList) {
            System.out.println(b);
        }

    }
}
