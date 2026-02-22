package model;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CoinCollectionTest {

    // DO NOT CHANGE THIS PART
    protected CoinCollection testCoinCollection;
    protected Coin coin1;
    protected Coin coin2;
    protected Coin coin3;
    protected Coin coin4;

    @BeforeEach
    public void setUp() {
        // DO NOT CHANGE THIS PART
        this.testCoinCollection = new CoinCollection();
        this.coin1 = new Coin("king_george", "1936 King George V", 1936);
        this.coin2 = new Coin("queen_elizabeth", "1965 Queen Elizabeth II ", 1965);
        this.coin3 = new Coin("king_george", "1921 King George V", 1921);
        this.coin4 = new Coin("peace_dollar", "1921 Peace Dollar", 1921);

        assertNotEquals(coin1, testCoinCollection); // IGNORE THIS LINE
    }

    @Test
    // Tests that addCoin behaves as specified when three different coins are added and
    // no exception is thrown.
    public void testAddThreeDifferentCoinsNoException() {
        // TODO
    }

    @Test
    // Tests that addCoin behaves as specified and throws DuplicateCoinException
    // with correct message when attempting to add a coin with the same ID multiple
    // times (even though no other fields of the coins match).
    public void testAddCoinSameIdButDifferentOtherFieldsException() {
        // TODO
    }

    // Tests that getCoins behaves as specified when a year in the future is provided.
    // Assume that the current year is 2024.
    @Test
    public void testGetCoinsYearAfterCurrentYear() {
        // TODO
    }

    @Test
    // Tests that getCoins behaves as specified when three coins have been added,
    // two of which have a year after the provided year.
    public void testGetCoinsSomeCoinsAfterGivenYear() {
        // TODO
    }

}
