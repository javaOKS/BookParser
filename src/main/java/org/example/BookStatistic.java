package org.example;

import java.util.List;

public class BookStatistic {
    private List<String> topWords;
    private int uniqueWords;

    public BookStatistic(List<String> topWords, int uniqueWords) {
        this.topWords = topWords;
        this.uniqueWords = uniqueWords;
    }

    @Override
    public String toString() {
        return "BookStatistic{" +
                "topWords=" + topWords +
                ", uniqueWords=" + uniqueWords +
                '}';
    }
}
