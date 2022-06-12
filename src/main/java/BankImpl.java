import exception.RecordNotFoundException;
import model.Payment;
import model.Person;
import repository.BankRepository;

import java.util.ArrayList;
import java.util.List;

public class BankImpl implements Bank {

    @Override
    public void loan(String bankName, String borrowerName, int principal, int noOfYears, double rateOfInterest) {
        String personBankName = String.format("%s_%s", bankName, borrowerName);
        int amountLeft = principal + (int) Math.ceil((double) principal * noOfYears * rateOfInterest / 100.0);
        int emiCount = noOfYears * 12;
        int monthlyEmi = (int) Math.ceil((double) amountLeft / (double) emiCount);
        Person person = new Person(bankName, borrowerName, amountLeft, emiCount, monthlyEmi);
        BankRepository.borrowersData.put(personBankName, person);
    }

    @Override
    public void payment(String bankName, String borrowerName, int lumpSumAmount, int emiNo) {
        String personBankName = String.format("%s_%s", bankName, borrowerName);
        List<Payment> payments = BankRepository.paymentRecord.getOrDefault(personBankName, null);
        if (payments == null)
            payments = new ArrayList<>();
        Payment payment = new Payment(bankName, borrowerName, lumpSumAmount, emiNo);
        payments.add(payment);
        BankRepository.paymentRecord.putIfAbsent(personBankName, payments);
    }

    @Override
    public String balance(String bankName, String borrowerName, int emiNo) throws RecordNotFoundException {
        String personBankName = String.format("%s_%s", bankName, borrowerName);
        Person data = BankRepository.borrowersData.getOrDefault(personBankName, null);
        if (data == null)
            throw new RecordNotFoundException();

        int lumpSumPayed = getLumpSum(personBankName, emiNo);
        int amountLeft = data.getTotalAmount() - emiNo * data.getMonthlyEmi() - lumpSumPayed;
        amountLeft = Math.max(amountLeft, 0);

        int emiLeft = (int) Math.ceil((double) amountLeft / (double) data.getMonthlyEmi());
        return String.format("%s %s %s %s", bankName, borrowerName, data.getTotalAmount() - amountLeft, emiLeft);
    }

    private int getLumpSum(String personBankName, int emiNo) {
        List<Payment> payments = BankRepository.paymentRecord.getOrDefault(personBankName, null);
        if (payments == null || payments.size() == 0)
            return 0;
        int totalLumpSum = 0;
        for (int i = 0; i < payments.size(); i++) {
            if(payments.get(i).getEmiCount()<= emiNo)
                totalLumpSum+=payments.get(i).getLumpSumAmount();
        }
        return totalLumpSum;
    }
}
