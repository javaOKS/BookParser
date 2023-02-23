package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    final static String PATH = "src/main/resources/";

    public static void main(String[] args) {
        BookParser parser = new BookParser();
        String cmdExit = "exit";
        String name;
        int amount = 4;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of book for statistic or enter \"" +
                cmdExit + "\" to exit:");

        while (!(name = scan.next()).equals(cmdExit)) {
            File book = new File(PATH + name);
            try {
                List<String> words = parser.getText(book);
                List<String> topwords = parser.topWords(words, amount);
                BookStatistic statistic = new BookStatistic(topwords, parser.uniqueWords(words));
                System.out.println(statistic);
                WriterFileStatistic fileStatistic = new WriterFileStatistic();
                fileStatistic.writerStatistic(PATH + name + "_statistic", statistic);
            } catch (FileNotFoundException e) {
                System.out.println("The book not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("If you want another book to statistic enter name of book or enter \"" +
                    cmdExit + "\" to exit:");
        }
        scan.close();
    }
}