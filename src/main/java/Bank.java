import exception.RecordNotFoundException;

public interface Bank {
    void loan(final String bankName,
              final String borrowerName,
              final int principal,
              final int noOfYears,
              final double rateOfInterest);

    void payment(final String bankName,
                 final String borrowerName,
                 final int lumpSumAmount,
                 final int emiNo) throws RecordNotFoundException;

    String balance(final String bankName,
                   final String borrowerName,
                   final int emiNo) throws RecordNotFoundException;
}
