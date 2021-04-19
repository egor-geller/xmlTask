package by.geller.xmlproject.parsers.stax;

import by.geller.xmlproject.exception.EmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

public class StaxParserTest {
    @Test
    public void parser() throws EmptyException, XMLStreamException, FileNotFoundException, TransformerException {
        Logger logger = LogManager.getLogger();
        String filePath = "src/main/java/by/geller/xmlproject/xmlFiles/Bank.xml";
        StaxParser staxParser = new StaxParser();
        staxParser.staxParser(filePath);
        logger.info("StAX parser is working");
    }
}
