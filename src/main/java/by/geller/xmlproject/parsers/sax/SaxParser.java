package by.geller.xmlproject.parsers.sax;

import by.geller.xmlproject.builder.AbstractBanksBuilder;
import by.geller.xmlproject.exception.EmptyException;
import by.geller.xmlproject.parsers.sax.handler.AdvancedXMLHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser extends AbstractBanksBuilder{
    public SaxParser(){}

    @Override
    public void buildArrayBanks(String filename) throws EmptyException {

    }

    public SaxParser(String filename) throws EmptyException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(new AdvancedXMLHandler());
            reader.parse(filename);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new EmptyException("Some problem with SAX parsing: " + e.getCause());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
