package by.geller.xmlproject;

import by.geller.xmlproject.builder.BanksBuilder;
import by.geller.xmlproject.entity.Banks;
import by.geller.xmlproject.exception.EmptyException;
import by.geller.xmlproject.parsers.sax.SaxParser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Banks> arrayList = new ArrayList<>();

    public static void main(String[] args) throws EmptyException {
        String path="./src/main/java/by/geller/xmlproject/xmlFiles/Bank.xml";
        SaxParser saxBanksBuilder = (SaxParser) BanksBuilder.createXML("SAX");
        saxBanksBuilder.buildArrayBanks(path);
        arrayList=saxBanksBuilder.getAbstractBanks();
        arrayList.forEach(System.out::println);
    }
}
