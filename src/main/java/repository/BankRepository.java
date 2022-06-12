package repository;

import model.Payment;
import model.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRepository {
    public static Map<String, Person> borrowersData = new HashMap<>();
    public static Map<String, List<Payment>> paymentRecord = new HashMap<>();
}
