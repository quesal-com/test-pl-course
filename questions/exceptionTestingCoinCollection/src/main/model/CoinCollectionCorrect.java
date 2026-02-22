package model;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

// See workspace file for all specifications.
public class CoinCollectionCorrect {

    public static final int CURRENT_YEAR = Year.now().getValue();

    protected List<Coin> coins;

    public CoinCollectionCorrect() {
        this.coins = new ArrayList<>();
    }

    public void addCoin(Coin coin) throws DuplicateCoinException {
        for (Coin c : this.coins) {
            if (c.equals(coin)) {
                throw new DuplicateCoinException(c.getTitle());
            }
        }
        coins.add(coin);
    }

    public List<Coin> getCoins(int year) {
        if (year > CURRENT_YEAR) {
            throw new IllegalArgumentException("year after the current year provided (text doesn't matter)");
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
