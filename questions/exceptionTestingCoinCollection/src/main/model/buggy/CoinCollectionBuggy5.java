package model.buggy;

import model.Coin;
import model.CoinCollectionCorrect;
import model.DuplicateCoinException;

public class CoinCollectionBuggy5 extends CoinCollectionCorrect {
    public void addCoin(Coin coin) throws DuplicateCoinException {
        coins.add(coin); // BUG
        for (Coin c : this.coins) {
            if (c.equals(coin)) {
                throw new DuplicateCoinException(c.getTitle());
            }
        }
        // coins.add(coin); // BUG
    }
}
