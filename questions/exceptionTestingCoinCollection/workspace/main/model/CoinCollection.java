package model;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

// Represents a collection of coins.
public class CoinCollection {
    // Internal ID: ABCDEFG (ignore this comment)

    // The current year as integer. Right now, this will evaluate to 2024.
    public static final int CURRENT_YEAR = Year.now().getValue();

    protected List<Coin> coins;

    // EFFECTS: constructs a coin collection without any coins present
    public CoinCollection() {
        // TODO
    }

    // MODIFIES: this
    // EFFECTS: adds the given coin to the collection. Insertion order is
    //  maintained. A coin can only be added if there is not already a coin
    //  with the same ID in the collection.
    //     IF: a coin with the same ID is already in the collection,
    //       THROWS: DuplicateCoinException and does not add the coin.
    //       The exception's message is "Duplicate: " followed by the title
    //       of the coin that's already in the list.
    public void addCoin(Coin coin) throws DuplicateCoinException {
        // TODO
    }

    // EFFECTS: returns a list of all coins that were published before
    //  or during the year provided as argument. In other words, all coins
    //  that have a year lower or equal to the provided value.
    //    IF: year > CURRENT_YEAR (in other words: a future year)
    //      THROWS: Java's built-in IllegalArgumentException (an unchecked exception)
    public List<Coin> getCoins(int year) {
        // TODO
        return null;
    }

}
