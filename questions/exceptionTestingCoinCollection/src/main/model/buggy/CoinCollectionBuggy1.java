package model.buggy;

import java.util.ArrayList;
import java.util.List;
import model.Coin;
import model.CoinCollectionCorrect;

public class CoinCollectionBuggy1 extends CoinCollectionCorrect {
    public List<Coin> getCoins(int year) {
        if (year > CURRENT_YEAR) {
            // throw new IllegalArgumentException("year after the current year provided (text doesn't matter)"); // BUG
        }
        List<Coin> result = new ArrayList<>();
        for (Coin coin : this.coins) {
            if (coin.getYear() <= year) {
                result.add(coin);
            }
        }
        return result;
    }
}
