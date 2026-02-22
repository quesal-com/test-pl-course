package model.buggy;

import java.util.ArrayList;
import java.util.List;
import model.Coin;
import model.CoinCollectionCorrect;

public class CoinCollectionBuggy2 extends CoinCollectionCorrect {
    public List<Coin> getCoins(int year) {
        if (year > CURRENT_YEAR) {
            throw new IllegalArgumentException("year after the current year provided (text doesn't matter)");
        }
        List<Coin> result = new ArrayList<>();
        for (Coin coin : this.coins) {
            // if (coin.getYear() <= year) { // BUG
                result.add(coin);
            // }
        }
        return result;
    }
}
