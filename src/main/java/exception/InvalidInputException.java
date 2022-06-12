package exception;

public class InvalidInputException extends Exception {
    String inputCommand;

    public InvalidInputException(String inputCommand) {
        this.inputCommand = inputCommand;
    }
}
