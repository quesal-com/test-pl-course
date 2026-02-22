package model;

// Exception to indicate that a duplicate coin was attempted to be added
// to a coin collection.
public class DuplicateCoinException extends Exception {

    public DuplicateCoinException(String coinTitle) {
        super("Duplicate: " + coinTitle);
    }
}
