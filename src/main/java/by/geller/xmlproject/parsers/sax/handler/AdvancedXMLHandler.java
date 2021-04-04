package by.geller.xmlproject.parsers.sax.handler;


import by.geller.xmlproject.Banks;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class AdvancedXMLHandler extends DefaultHandler {

    private String bankName, registrationInCountry, typeOfDeposit, depositorsName, accountId, annualPercentage;
    private Integer depositAmount;
    private String termOfDeposit;
    private String currentElement;

    Banks banks;
    public static final ArrayList<Banks> arrayList = new ArrayList<>();

    final String BANK_NAME_TAG = "bank-name";
    final String ACCOUNT_ID_TAG = "account-id";
    final String ANNUAL_PERCENTAGE_TAG = "annual-percentage";
    final String DEPOSIT_AMOUNT_TAG = "deposit-amount";
    final String DEPOSITORS_NAME_TAG = "depositors-name";
    final String REGISTRATION_IN_COUNTRY_TAG = "registration-in-country";
    final String TERM_OF_DEPOSIT_TAG = "term-of-deposit";
    final String TYPE_OF_DEPOSIT_TAG = "type-of-deposit";

    Logger logger = LogManager.getLogger();

    @Override
    public void startDocument() throws SAXException {
        banks = new Banks();
        logger.info("SAX parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        for (int i = 0; i < attributes.getLength(); i++) {
            //currentElement.append(" ").append(attributes.getQName(i)).append(" = ").append(attributes.getValue(i));
            currentElement += " " + attributes.getQName(i) + " = " + attributes.getValue(i);
        }
        logger.info(currentElement);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String information = new String(ch, start, length);

        information = information.replace("\n", "").trim();
        if (information.contains("<") || currentElement == null){
            return;
        }


        if (!information.isEmpty()) {
            if (currentElement.equals(BANK_NAME_TAG)) {
                banks.setBankName(information);
            }
            if (currentElement.equals(ACCOUNT_ID_TAG)) {
                banks.setAccountId(information);
            }
            if (currentElement.equals(ANNUAL_PERCENTAGE_TAG)) {
                banks.setAnnualPercentage(information);
            }
            if (currentElement.equals(DEPOSIT_AMOUNT_TAG)) {
                banks.setDepositAmount(Integer.parseInt(information));
            }
            if (currentElement.equals(DEPOSITORS_NAME_TAG)) {
                banks.setDepositorsName(information);
            }
            if (currentElement.equals(REGISTRATION_IN_COUNTRY_TAG)) {
                banks.setRegistrationInCountry(information);
            }
            if (currentElement.equals(TERM_OF_DEPOSIT_TAG)) {
                banks.setTermOfDeposit(information);
            }
            if (currentElement.equals(TYPE_OF_DEPOSIT_TAG)) {
                banks.setTypeOfDeposit(information);
            }
        }
        //TODO: Insertion to array problem
        if (currentElement.equals(TERM_OF_DEPOSIT_TAG)){
            arrayList.add(banks);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ((bankName != null && !bankName.isEmpty()) && (accountId != null && !accountId.isEmpty())
                && (annualPercentage != null && !annualPercentage.isEmpty()) && (depositAmount != null && depositAmount < 0)
                && (depositorsName != null && !depositorsName.isEmpty()) && (registrationInCountry != null && !registrationInCountry.isEmpty())
                && (termOfDeposit != null && !termOfDeposit.isEmpty()) && (typeOfDeposit != null && !typeOfDeposit.isEmpty())) {

            bankName = null;
            accountId = null;
            annualPercentage = null;
            depositAmount = null;
            depositorsName = null;
            registrationInCountry = null;
            termOfDeposit = null;
            typeOfDeposit = null;
        }


    }

    @Override
    public void endDocument() throws SAXException {

        logger.info("SAX parsing ended");
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
