package by.geller.xmlproject.builder;

import by.geller.xmlproject.exception.EmptyException;
import by.geller.xmlproject.parsers.dom.DOMParser;
import by.geller.xmlproject.parsers.sax.SaxParser;
import by.geller.xmlproject.parsers.stax.StaxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class BanksBuilder {
    private static final Logger logger = LogManager.getLogger();

    private enum TypeOfParser{
        DOM, SAX, STAX
    }

    public static AbstractBanksBuilder createXML(String typeOfParser) throws EmptyException {
        logger.info("Method to create Banks Builder with the parser: {}", typeOfParser);
        TypeOfParser type = TypeOfParser.valueOf(typeOfParser.toLowerCase(Locale.ROOT));
        switch (type){
            case DOM:
                return new DOMParser();
            case SAX:
                return new SaxParser();
            case STAX:
                return new StaxParser();
            default:
                throw new EmptyException("Wrong type of parser");
        }
    }
}
