import exception.RecordNotFoundException;

import java.util.Scanner;

public class Geektrust {
    public static void main(String[] args) throws RecordNotFoundException {
        Bank bank = new BankImpl();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String inputCommand = scanner.nextLine().trim();
            String command[] = inputCommand.split(" ");
            switch (command[0]) {
                case "LOAN":
                    bank.loan(command[1],
                            command[2],
                            Integer.parseInt(command[3]),
                            Integer.parseInt(command[4]),
                            Double.parseDouble(command[5]));
                    break;
                case "PAYMENT":
                    bank.payment(command[1],
                            command[2],
                            Integer.parseInt(command[3]),
                            Integer.parseInt(command[4]));
                    break;
                case "BALANCE":
                    String balanceOutput = bank.balance(command[1],
                            command[2],
                            Integer.parseInt(command[3]));
                    System.out.println(balanceOutput);
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
