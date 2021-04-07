package by.geller.xmlproject.parsers.stax.handler;

import by.geller.xmlproject.exception.EmptyException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaxAdvancedXMLHandler {
    public StringBuilder processXMLFile(File xmlFile) throws FileNotFoundException, XMLStreamException, EmptyException {
        StringBuilder stringBuilder = new StringBuilder();
        XMLStreamReader xmlStreamReader = (XMLInputFactory.newInstance()).createXMLStreamReader(new FileInputStream(xmlFile));
        while (xmlStreamReader.hasNext()) {
            switch (xmlStreamReader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    stringBuilder.append("<").append(xmlStreamReader.getLocalName()).append(">");
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (!xmlStreamReader.isWhiteSpace()) {
                        stringBuilder.append(xmlStreamReader.getText());
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    stringBuilder.append("</").append(xmlStreamReader.getLocalName()).append(">");
                    break;
                default:
                    break;
            }
        }
        return stringBuilder;
    }
}
