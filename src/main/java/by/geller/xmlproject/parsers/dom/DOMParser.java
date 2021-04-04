package by.geller.xmlproject.parsers.dom;

import by.geller.xmlproject.Banks;
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
    private ArrayList<Banks> arrayOfBanks;
    private DocumentBuilder documentBuilder;

    public DOMParser() throws EmptyException {
        arrayOfBanks = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (Exception e) {
            throw new EmptyException("Parser config exception: " + e.getCause());
        }
    }

    public ArrayList<Banks> getBanks() {
        return (ArrayList<Banks>) arrayOfBanks.clone();
    }

    public void buildArray(String filename) throws EmptyException {
        Document doc;
        try {

            doc = documentBuilder.parse(new File(filename)); //file not found exception???????
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
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

    private Banks buildBank(Element bankElement) throws EmptyException {
        Banks banks = new Banks();

        if (banks == null) {
            logger.error("Banks are null");
            throw new EmptyException("Banks are null");
        }

        banks.setBankName(getElementTextContent(bankElement, "bank-name"));
        banks.setAccountId(getElementTextContent(bankElement, "account-id"));
        banks.setAnnualPercentage(getElementTextContent(bankElement, "annual-percentage"));
        Integer depositAmount = Integer.parseInt(getElementTextContent(bankElement, "deposit-amount"));
        banks.setDepositAmount(depositAmount); //Integer
        banks.setDepositorsName(getElementTextContent(bankElement, "depositors-name"));
        banks.setRegistrationInCountry(getElementTextContent(bankElement, "registration-in-country"));
        String timeInString = getElementTextContent(bankElement, "term-of-deposit"); //parse string to date
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = time.format(timeFormat);
        banks.setTermOfDeposit(formattedTime); //Date
        banks.setTypeOfDeposit(getElementTextContent(bankElement, "type-of-deposit"));

        /*

         */

        return banks;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

    /*public static void main(String[] args) throws EmptyException {

        *//*DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {

            File fXmlFile = new File("xmlFiles/Banks.xml");

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);



            doc.getDocumentElement().normalize();

            NodeList bankNameList = doc.getElementsByTagName("bank");


            for (int temp = 0; temp < bankNameList.getLength(); temp++) {

                Node nNode = bankNameList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("ID : " + eElement.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("Bank name : " + eElement.getElementsByTagName("bank-name").item(0).getTextContent());
                    System.out.println("Registered in : " + eElement.getElementsByTagName("registration-in-country").item(0).getTextContent());
                    System.out.println("Type of deposit : " + eElement.getElementsByTagName("type-of-deposit").item(0).getTextContent());
                    System.out.println("Depositors name : " + eElement.getElementsByTagName("depositors-name").item(0).getTextContent());
                    System.out.println("Account id : " + eElement.getElementsByTagName("account-id").item(0).getTextContent());
                    System.out.println("Deposit amount : " + eElement.getElementsByTagName("deposit-amount").item(0).getTextContent());
                    System.out.println("Annual percentage : " + eElement.getElementsByTagName("annual-percentage").item(0).getTextContent());
                    System.out.println("Term of deposit : " + eElement.getElementsByTagName("term-of-deposit").item(0).getTextContent());

                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e){
            logger.error("Parser is not configured properly");
            throw new EmptyException("Parser is not configured properly: " + e.getCause());
        }
    }
*/
