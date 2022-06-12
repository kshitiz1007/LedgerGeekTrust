package model;

public class Person {
    String bankName;
    String personName;
    int totalAmount;
    int emiCount;
    int monthlyEmi;

    public Person(String bankName, String personName, int totalAmount, int emiCount, int monthlyEmi) {
        this.bankName = bankName;
        this.personName = personName;
        this.totalAmount = totalAmount;
        this.emiCount = emiCount;
        this.monthlyEmi = monthlyEmi;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
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

    public int getEmiCount() {
        return emiCount;
    }

    public void setEmiCount(int emiCount) {
        this.emiCount = emiCount;
    }

    public int getMonthlyEmi() {
        return monthlyEmi;
    }

    public void setMonthlyEmi(int monthlyEmi) {
        this.monthlyEmi = monthlyEmi;
    }
}
