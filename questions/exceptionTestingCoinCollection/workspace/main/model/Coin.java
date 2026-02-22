package model;

// Represents a coin with id, title, and year.
public class Coin {
    // Internal ID: ABCDEFG (ignore this comment)

    private String id;
    private String title;
    private int year;

    // EFFECTS: creates a coin with the given id, title, and year.
    public Coin(String id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    // EFFECTS: returns true if this object is equal to the object given
    // as argument. Coins are considered equal if their IDs are equal.
    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (o.getClass() == this.getClass()) {
            Coin otherCoin = (Coin) o;
            equals = otherCoin.id.equals(this.id);
        }
        return equals;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}

