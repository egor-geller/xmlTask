package by.geller.xmlproject.builder;

import by.geller.xmlproject.entity.Banks;
import by.geller.xmlproject.exception.EmptyException;

import java.util.ArrayList;


public abstract class AbstractBanksBuilder {
    private ArrayList<Banks> abstractBanks;

    public AbstractBanksBuilder(){
        abstractBanks = new ArrayList<>();
    }

    public AbstractBanksBuilder(ArrayList<Banks> abstractBanks){
        this.abstractBanks = abstractBanks;
    }

    public ArrayList<Banks> getAbstractBanks() throws EmptyException {
        if (abstractBanks.isEmpty()){
            throw new EmptyException("Array is empty");
        }
        return (ArrayList<Banks>) abstractBanks.clone();
    }

    public abstract void buildArrayBanks(String filename) throws EmptyException;
}
