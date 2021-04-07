package by.geller.xmlproject.parsers.sax.handler;

import by.geller.xmlproject.entity.Banks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class AdvancedXMLHandler extends DefaultHandler {
    private String currentElement;

    Banks banks = new Banks();
    public static final Set<Banks> arrayList = new HashSet<>();

    static final String BANK_NAME_TAG = "bank-name";
    static final String ACCOUNT_ID_TAG = "account-id";
    static final String ANNUAL_PERCENTAGE_TAG = "annual-percentage";
    static final String DEPOSIT_AMOUNT_TAG = "deposit-amount";
    static final String DEPOSITORS_NAME_TAG = "depositors-name";
    static final String REGISTRATION_IN_COUNTRY_TAG = "registration-in-country";
    static final String TERM_OF_DEPOSIT_TAG = "term-of-deposit";
    static final String TYPE_OF_DEPOSIT_TAG = "type-of-deposit";

    Logger logger = LogManager.getLogger();

    @Override
    public void startDocument() {
        logger.info("SAX parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        logger.info(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String information = new String(ch, start, length);

        information = information.replace("\n", "").trim();
        if (information.contains("<") || currentElement == null) {
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
                arrayList.add(banks);
                banks = new Banks();
            }
            if (currentElement.equals(TYPE_OF_DEPOSIT_TAG)) {
                banks.setTypeOfDeposit(information);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        logger.info("Element has ended");
    }

    @Override
    public void endDocument() {
        logger.info("SAX parsing ended");
    }
}
