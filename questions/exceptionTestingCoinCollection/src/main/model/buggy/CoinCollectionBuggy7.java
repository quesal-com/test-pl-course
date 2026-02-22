package model.buggy;

import model.Coin;
import model.CoinCollectionCorrect;
import model.DuplicateCoinException;

public class CoinCollectionBuggy7 extends CoinCollectionCorrect {
    public void addCoin(Coin coin) throws DuplicateCoinException {
        for (Coin c : this.coins) {
            if (c.getTitle().equals(coin.getTitle())) { // BUG
                throw new DuplicateCoinException(c.getTitle());
            }
        }
        coins.add(coin);
    }
}
