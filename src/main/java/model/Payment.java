package model;


public class Payment {
    String bankName;
    String personName;
    int lumpSumAmount;
    int emiCount;

    public Payment(String bankName, String personName, int lumpSumAmount, int emiCount) {
        this.bankName = bankName;
        this.personName = personName;
        this.lumpSumAmount = lumpSumAmount;
        this.emiCount = emiCount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getLumpSumAmount() {
        return lumpSumAmount;
    }

    public void setLumpSumAmount(int lumpSumAmount) {
        this.lumpSumAmount = lumpSumAmount;
    }

    public int getEmiCount() {
        return emiCount;
    }

    public void setEmiCount(int emiCount) {
        this.emiCount = emiCount;
    }
}
