package by.geller.xmlproject;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Banks {
    private String bankName, registrationInCountry, typeOfDeposit, depositorsName, accountId, annualPercentage;
    private Integer depositAmount;
    private String termOfDeposit;

    public Banks() {

    }

    public Banks(String bankName, String registrationInCountry, String typeOfDeposit, String depositorsName
            , String accountId, String annualPercentage, Integer depositAmount, String termOfDeposit) {
        this.bankName = bankName;
        this.registrationInCountry = registrationInCountry;
        this.typeOfDeposit = typeOfDeposit;
        this.depositorsName = depositorsName;
        this.accountId = accountId;
        this.annualPercentage = annualPercentage;
        this.depositAmount = depositAmount;
        this.termOfDeposit = termOfDeposit;
    }

    public String getTermOfDeposit() {
        return termOfDeposit;
    }

    public Integer getDepositAmount() {
        return depositAmount;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAnnualPercentage() {
        return annualPercentage;
    }

    public String getBankName() {
        return bankName;
    }

    public String getDepositorsName() {
        return depositorsName;
    }

    public String getRegistrationInCountry() {
        return registrationInCountry;
    }

    public String getTypeOfDeposit() {
        return typeOfDeposit;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setAnnualPercentage(String annualPercentage) {
        this.annualPercentage = annualPercentage;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setDepositAmount(Integer depositAmount) {
        this.depositAmount = depositAmount;
    }

    public void setDepositorsName(String depositorsName) {
        this.depositorsName = depositorsName;
    }

    public void setRegistrationInCountry(String registrationInCountry) {
        this.registrationInCountry = registrationInCountry;
    }

    public void setTermOfDeposit(String termOfDeposit) {
        this.termOfDeposit = termOfDeposit;
    }

    public void setTypeOfDeposit(String typeOfDeposit) {
        this.typeOfDeposit = typeOfDeposit;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bank:" + "\n\t\tbankName= ").append(bankName).append('\n')
                .append("\t\tregistrationInCountry= ").append(registrationInCountry).append('\n')
                .append("\t\ttypeOfDeposit= ").append(typeOfDeposit).append('\n').append("\t\tdepositorsName= ")
                .append(depositorsName).append('\n').append("\t\taccountId= ").append(accountId).append('\n')
                .append("\t\tannualPercentage= ").append(annualPercentage).append('\n').append("\t\tdepositAmount= ")
                .append(depositAmount).append('\n').append("\t\ttermOfDeposit= ").append(termOfDeposit).append('\n');
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banks banks = (Banks) o;
        return bankName.equals(banks.bankName) && Objects.equals(registrationInCountry, banks.registrationInCountry)
                && typeOfDeposit.equals(banks.typeOfDeposit) && depositorsName.equals(banks.depositorsName)
                && accountId.equals(banks.accountId) && Objects.equals(annualPercentage, banks.annualPercentage)
                && depositAmount.equals(banks.depositAmount) && termOfDeposit.equals(banks.termOfDeposit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, registrationInCountry, typeOfDeposit, depositorsName, accountId, annualPercentage, depositAmount, termOfDeposit);
    }
}
