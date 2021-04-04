package by.geller.xmlproject.parsers.dom;

import by.geller.xmlproject.exception.EmptyException;
import org.testng.annotations.Test;

public class DOMParserTest {
    @Test
    public void parser() throws EmptyException {
        String filePath = "src/main/java/by/geller/xmlproject/xmlFiles/Bank.xml";
        DOMParser domParser = new DOMParser();
        domParser.buildArray(filePath);
        System.out.println(domParser.getBanks());
    }
}
