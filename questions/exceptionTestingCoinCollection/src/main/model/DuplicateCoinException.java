package model;

public class DuplicateCoinException extends Exception {

    public DuplicateCoinException(String cointTitle) {
        super("Duplicate: " + cointTitle);
    }
}
