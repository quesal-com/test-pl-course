package model;

// See workspace file for all specifications.
public class Coin {
    private String id;
    private String title;
    private int year;

    public Coin(String id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

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

