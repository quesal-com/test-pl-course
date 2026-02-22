package model.buggy;

import model.Coin;
import model.CoinCollectionCorrect;
import model.DuplicateCoinException;

public class CoinCollectionBuggy10 extends CoinCollectionCorrect {
    public void addCoin(Coin coin) throws DuplicateCoinException {
        for (Coin c : this.coins) {
            if (c.equals(coin)) {
                throw new DuplicateCoinException("Duplicate: " + c.getTitle()); // BUG
            }
        }
        //coins.add(coin); BUG
    }
}
