package model;

import ca.ubc.cs.autotest.AutoTest;
import ca.ubc.cs.autotest.Grader;
import ca.ubc.cs.autotest.Hint;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoTest
public class CoinCollectionAutoTest extends CoinCollectionTest {

    @Test
    @Grader(rank=10)
    @Hint("test for Constructor")
    public void testConstructor() {
        List<Coin> coins = testCoinCollection.getCoins(2024);
        assertEquals(0, coins.size());
    }

    @Test
    @Grader(rank=20)
    @Hint("test for adding single coin")
    public void testAddOneCoinNoException() {
        try {
            testCoinCollection.addCoin(coin1);
        } catch (DuplicateCoinException e) {
            fail("Unexpected exception");
        }
        assertEquals(Collections.singletonList(coin1), testCoinCollection.getCoins(2024));
    }

    @Test
    @Grader(rank=30)
    @Hint("test for adding multiple coins")
    public void testAddThreeDifferentCoinsNoException() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin2);
            testCoinCollection.addCoin(coin4);
        } catch (DuplicateCoinException e) {
            fail("Unexpected exception");
        }
        assertEquals(Arrays.asList(coin1, coin2, coin4), testCoinCollection.getCoins(2024));
    }

    @Test
    @Grader(rank=31)
    @Hint("test for adding multiple coins where ordering is not checked")
    public void testAddThreeDifferentCoinsNoExceptionNoOrderChecking() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin2);
            testCoinCollection.addCoin(coin4);
        } catch (DuplicateCoinException e) {
            fail("Unexpected exception");
        }
        assertTrue(testCoinCollection.getCoins(2024).contains(coin1));
        assertTrue(testCoinCollection.getCoins(2024).contains(coin2));
        assertTrue(testCoinCollection.getCoins(2024).contains(coin4));
    }

    @Test
    @Grader(rank=32)
    @Hint("test for adding two coins where ordering is checked")
    public void testAddTwoDifferentCoinsNoExceptionOrderChecking() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin2);
        } catch (DuplicateCoinException e) {
            fail("Unexpected exception");
        }
        assertEquals(2, testCoinCollection.getCoins(2024).size());
        assertEquals(coin1, testCoinCollection.getCoins(2024).get(0));
        assertEquals(coin2, testCoinCollection.getCoins(2024).get(1));
    }

    @Test
    @Grader(rank=33)
    @Hint("test for adding three coins where ordering is checked")
    public void testAddThreeDifferentCoinsNoExceptionOrderChecking() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin2);
            testCoinCollection.addCoin(coin4);
        } catch (DuplicateCoinException e) {
            fail("Unexpected exception");
        }
        assertEquals(3, testCoinCollection.getCoins(2024).size());
        assertEquals(coin1, testCoinCollection.getCoins(2024).get(0));
        assertEquals(coin2, testCoinCollection.getCoins(2024).get(1));
        assertEquals(coin4, testCoinCollection.getCoins(2024).get(2));
    }

    @Test
    @Grader(rank=40)
    @Hint("test ensuring DuplicateCoinException produces the correct message")
    public void testAddSameCoinMultipleTimesException() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin1);
            fail("Should not have succeeded.");
        } catch (DuplicateCoinException e) {
            assertEquals("Duplicate: " + coin1.getTitle(), e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception.");
        }
        assertEquals(Collections.singletonList(coin1), testCoinCollection.getCoins(2024));
    }

    @Test
    @Grader(rank=41)
    @Hint("test for addCoin where DuplicateCoinException is thrown after adding same object twice")
    public void testAddSameCoinMultipleTimesExceptionNoMessageCheck() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin1);
            fail("Should not have succeeded.");
        } catch (DuplicateCoinException e) {
            // Expected
        } catch (Exception e) {
            fail("Unexpected exception.");
        }
        assertEquals(Collections.singletonList(coin1), testCoinCollection.getCoins(2024));
    }

    @Test
    @Grader(rank=50)
    @Hint("test for DuplicateCoinException with equal coins; error message checked")
    public void testAddCoinExceptionWithErrorMessageCheck() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin3);
            fail("Should not have succeeded.");
        } catch (DuplicateCoinException e) {
            assertEquals("Duplicate: " + coin1.getTitle(), e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception.");
        }
        assertEquals(Collections.singletonList(coin1), testCoinCollection.getCoins(2024));
    }

    @Test
    @Grader(rank=51)
    @Hint("test for DuplicateCoinException with equal coins; error message ignored")
    public void testAddCoinExceptionWithoutErrorMessageCheck() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin3);
            fail("Should not have succeeded.");
        } catch (DuplicateCoinException e) {
            // Expected
        }
    }

    @Test
    @Grader(rank=52)
    @Hint("test for DuplicateCoinException with equal coins; list modification ignored")
    public void testAddCoinExceptionListModificationIgnored() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin3);
            fail("Should not have succeeded.");
        } catch (DuplicateCoinException e) {
            assertEquals("Duplicate: " + coin1.getTitle(), e.getMessage());
        }
    }

    @Test
    @Grader(rank=60)
    @Hint("test that adds coins with different ids but same other fields")
    public void testToAddCoinDistinctIdsSameOtherFields() {
        Coin coinOne = new Coin("lincoln_2", "1902 Lincoln Junior", 700);
        Coin coinTwo = new Coin("lincoln_1", "1902 Lincoln Junior", 700);
        try {
            testCoinCollection.addCoin(coinOne);
            testCoinCollection.addCoin(coinTwo);
        } catch (DuplicateCoinException e) {
            fail("Unexpected Exception");
        }
        List<Coin> coins = testCoinCollection.getCoins(2024);
        assertEquals(2, coins.size());
        assertTrue(coins.contains(coinOne));
        assertTrue(coins.contains(coinTwo));
    }

    @Test
    @Grader(rank=70)
    @Hint("test ensuring getCoins throws IllegalArgumentException when year is after current year")
    public void testGetCoinsYearAfterCurrentYear() {
        try {
            testCoinCollection.getCoins(2024 + 1);
            fail("Should not have succeeded.");
        } catch (IllegalArgumentException e) {
            // Expected
        }
        try {
            testCoinCollection.getCoins(2024 + 2);
            fail("Should not have succeeded.");
        } catch (IllegalArgumentException e) {
            // Expected
        }
        try {
            testCoinCollection.getCoins(2024 + 1000);
            fail("Should not have succeeded.");
        } catch (IllegalArgumentException e) {
            // Expected
        }
    }

    @Test
    @Grader(rank=71)
    @Hint("test ensuring getCoins does not throw IllegalArgumentException when year is current year")
    public void testGetCoinsCurrentYear() {
        try {
            testCoinCollection.addCoin(coin1);
        } catch (DuplicateCoinException e) {
            fail("Unexpected Exception");
        }
        try {
            assertFalse(testCoinCollection.getCoins(2024).isEmpty());
        } catch (IllegalArgumentException e) {
            fail("Unexpected Exception");
        }
    }

    @Test
    @Grader(rank=72)
    @Hint("test ensuring getCoins does not throw IllegalArgumentException when year is before current year")
    public void testGetCoinsMinValueIsMoreThanZero() {
        try {
            testCoinCollection.addCoin(coin3);
        } catch (DuplicateCoinException e) {
            fail("Unexpected Exception");
        }
        try {
            assertFalse(testCoinCollection.getCoins(1940).isEmpty());
            assertFalse(testCoinCollection.getCoins(1950).isEmpty());
            assertFalse(testCoinCollection.getCoins(1960).isEmpty());
        } catch (IllegalArgumentException e) {
            fail("Unexpected Exception");
        }
    }

    @Test
    @Grader(rank=73)
    @Hint("test ensuring getCoins does not throw IllegalArgumentException when year is 0")
    public void testGetCoinsYear0() {
        try {
            testCoinCollection.addCoin(coin1);
        } catch (DuplicateCoinException e) {
            fail("Unexpected Exception");
        }
        try {
            assertTrue(testCoinCollection.getCoins(0).isEmpty());
        } catch (IllegalArgumentException e) {
            fail("Unexpected Exception");
        }
    }

    @Test
    @Grader(rank=74)
    @Hint("test ensuring getCoins does not throw IllegalArgumentException when year is negative")
    public void testGetCoinsYearNegative() {
        try {
            testCoinCollection.addCoin(coin1);
        } catch (DuplicateCoinException e) {
            fail("Unexpected Exception");
        }
        try {
            assertTrue(testCoinCollection.getCoins(-10).isEmpty());
        } catch (IllegalArgumentException e) {
            fail("Unexpected Exception");
        }
    }

    @Test
    @Grader(rank=80)
    @Hint("test for getCoins with no results")
    public void testGetCoinsNoResults() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin2);
            testCoinCollection.addCoin(coin4);
        } catch (DuplicateCoinException e) {
            fail("Unexpected Exception");
        }

        assertTrue(testCoinCollection.getCoins(0).isEmpty());
    }

    @Test
    @Grader(rank=81)
    @Hint("test for getCoins with one result")
    public void testGetCoinsOneResult() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin2);
            testCoinCollection.addCoin(coin4);
        } catch (DuplicateCoinException e) {
            fail("Unexpected Exception");
        }

        List<Coin> coinList = testCoinCollection.getCoins(1922);
        assertEquals(1, coinList.size());
        assertTrue(coinList.contains(coin4));
    }

    @Test
    @Grader(rank=82)
    @Hint("test for getCoins with two results")
    public void testGetCoinsTwoResults() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin2);
            testCoinCollection.addCoin(coin4);
        } catch (DuplicateCoinException e) {
            fail("Unexpected Exception");
        }

        List<Coin> coinList = testCoinCollection.getCoins(1940);
        assertEquals(2, coinList.size());
        assertTrue(coinList.contains(coin1));
        assertTrue(coinList.contains(coin4));
    }

    @Test
    @Grader(rank=83)
    @Hint("test for getCoins with three results")
    public void testGetCoinsThreeResults() {
        try {
            testCoinCollection.addCoin(coin1);
            testCoinCollection.addCoin(coin2);
            testCoinCollection.addCoin(coin4);
        } catch (DuplicateCoinException e) {
            fail("Unexpected Exception");
        }

        List<Coin> coinList = testCoinCollection.getCoins(2024);
        assertEquals(3, coinList.size());
        assertTrue(coinList.contains(coin1));
        assertTrue(coinList.contains(coin2));
        assertTrue(coinList.contains(coin4));
    }
}
