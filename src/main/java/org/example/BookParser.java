package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BookParser {
    public List<String> topWords(List<String> words, int amount) {
        return words.stream()
                .distinct()
                .sorted(Comparator.comparingInt(word -> (Collections.frequency(words, word))).reversed())
                .limit(amount)
                .collect(Collectors.toList());
    }

    public List<String> getText(File book) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(book));
        List<String> text = reader.lines()
                .flatMap(line -> Arrays.stream(line.split("[,. ?!:]")))
                .filter(word -> word.length() > 2)
                .collect(Collectors.toList());
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("It's not possible to close the file.");
        }
        return text;
    }

    public int uniqueWords(List<String> words) {
        return new HashSet<>(words).size();
    }
}
