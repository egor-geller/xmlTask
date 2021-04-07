package by.geller.xmlproject.parsers.stax;

import by.geller.xmlproject.exception.EmptyException;
import by.geller.xmlproject.parsers.stax.handler.StaxAdvancedXMLHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Driver;

public class StaxParser {
    public void staxParser(String path) throws EmptyException, XMLStreamException, FileNotFoundException, TransformerException {
        System.out.println(transformXML(4, (new StaxAdvancedXMLHandler()).processXMLFile(new File(path))));
        //Logger logger = LogManager.getLogger();
        //logger.info("works");
    }

    public String transformXML(int indentation, StringBuilder rawXML) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", indentation);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult streamResult = new StreamResult(new StringWriter());
        transformer.transform(new StreamSource(new StringReader(rawXML.toString())), streamResult);

        return streamResult.getWriter().toString();
    }
}
