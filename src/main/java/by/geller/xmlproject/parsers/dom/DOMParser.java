package by.geller.xmlproject.parsers.dom;

import by.geller.xmlproject.entity.Banks;
import by.geller.xmlproject.exception.EmptyException;
import org.w3c.dom.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DOMParser {
    Logger logger = LogManager.getLogger();
    private final Set<Banks> arrayOfBanks = new HashSet<>();
    private final DocumentBuilder documentBuilder;

    public DOMParser() throws EmptyException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (Exception e) {
            throw new EmptyException("Parser config exception: " + e.getCause());
        }
    }

    public List<Banks> getBanks() {
        return new ArrayList<>(arrayOfBanks);
    }

    public void buildArray(String filename) throws EmptyException {
        Document doc;
        try {

            doc = documentBuilder.parse(new File(filename));
            logger.info("Root element: {}",doc.getDocumentElement().getNodeName());
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();

            NodeList banksList = root.getElementsByTagName("bank");
            for (int i = 0; i < banksList.getLength(); i++) {
                Element bankElement = (Element) banksList.item(i);
                Banks banks = buildBank(bankElement);
                arrayOfBanks.add(banks);
            }
        } catch (Exception e) {
            throw new EmptyException("Parsing problem, file not found: " + e.getCause());
        }
    }

    private Banks buildBank(Element bankElement) {
        Banks banks = new Banks();

        banks.setBankName(getElementTextContent(bankElement, "bank-name"));
        banks.setAccountId(getElementTextContent(bankElement, "account-id"));
        banks.setAnnualPercentage(getElementTextContent(bankElement, "annual-percentage"));
        int depositAmount = Integer.parseInt(getElementTextContent(bankElement, "deposit-amount"));
        banks.setDepositAmount(depositAmount); //Integer
        banks.setDepositorsName(getElementTextContent(bankElement, "depositors-name"));
        banks.setRegistrationInCountry(getElementTextContent(bankElement, "registration-in-country"));
        String timeInString = getElementTextContent(bankElement, "term-of-deposit"); //parse string to date
        LocalDateTime time = LocalDateTime.parse(timeInString, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        banks.setTermOfDeposit(time.toString()); //Date
        banks.setTypeOfDeposit(getElementTextContent(bankElement, "type-of-deposit"));

        return banks;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
