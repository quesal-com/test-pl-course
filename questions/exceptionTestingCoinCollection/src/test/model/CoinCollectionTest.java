package model;

import ca.ubc.cs.autotest.Hint;
import java.util.List;
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

    @Hint("test for addCoin with three different coins")
    @Test
    // Tests that addCoin behaves as specified when three different coins are added and
    // no exception is thrown.
    public void testAddThreeDifferentCoinsNoException() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin2);
            testCoinCollection.addCoin(coin4);
        } catch (DuplicateCoinException e) {
            fail("Unexpected exception");
        }
        List<Coin> coins = testCoinCollection.getCoins(2024);
        assertEquals(3, coins.size());
        assertEquals(coin1, coins.get(0));
        assertEquals(coin2, coins.get(1));
        assertEquals(coin4, coins.get(2));
    }

    @Hint("test for addCoin with two coins with same ID")
    @Test
    // Tests that addCoin behaves as specified and throws DuplicateCoinException
    // with correct message when attempting to add a coin with the same ID multiple
    // times (even though no other fields of the coins match).
    public void testAddCoinSameIdButDifferentOtherFieldsException() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin3);
            fail("Should not have succeeded.");
        } catch (DuplicateCoinException e) {
            assertEquals("Duplicate: " + coin1.getTitle(), e.getMessage());
        }
        List<Coin> coins = testCoinCollection.getCoins(2024);
        assertEquals(1, coins.size());
        assertEquals(coin1, coins.get(0));
    }

    @Hint("test for getCoins with year in the future")
    @Test
    // Tests that getCoins behaves as specified when a year in the future is provided.
    public void testGetCoinsYearAfterCurrentYear() {
        try {
            testCoinCollection.getCoins(2050);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Hint("test for getCoins with three coins and with two having year after provided year")
    @Test
    // Tests that getCoins behaves as specified when three coins have been added,
    // two of which have a year after the provided year.
    public void testGetCoinsSomeCoinsAfterGivenYear() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin2);
            testCoinCollection.addCoin(coin4);
        } catch (Exception e) {
            fail("Unexpected exception.");
        }
        List<Coin> coins = testCoinCollection.getCoins(1925);
        assertEquals(1, coins.size());
        assertEquals(coin4, coins.get(0));
    }

    // NOT USED
//    @Hint("test for addCoin when attempting to add the same coin object multiple times")
//    @Test
//    // Tests that addCoin behaves as specified and throws DuplicateCoinException with
//    // correct message when attempting to add the same coin object multiple times.
//    public void testAddSameCoinMultipleTimesException() {
//        try {
//            testCoinCollection.addCoin(coin1);
//            testCoinCollection.addCoin(coin1);
//            fail("Should not have succeeded.");
//        } catch (DuplicateCoinException e) {
//            assertEquals("Duplicate: " + coin1.getTitle(), e.getMessage());
//        }
//        List<Coin> coins = testCoinCollection.getCoins(2024);
//        assertEquals(1, coins.size());
//        assertEquals(coin1, coins.get(0));
//    }

    // NOT USED
//    @Test
//    // Tests that addCoin behaves as specified when one coin is added.
//    public void testAddOneCoinNoException() {
//        try {
//            testCoinCollection.addCoin(coin1);
//        } catch (DuplicateCoinException e) {
//            fail("Unexpected exception");
//        }
//        assertEquals(Collections.singletonList(coin1), testCoinCollection.getCoins(2024));
//    }

}
