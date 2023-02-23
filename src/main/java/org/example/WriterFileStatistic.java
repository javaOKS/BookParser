package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterFileStatistic {
    public void writerStatistic(String pathname, BookStatistic statistic) throws IOException {
        BufferedWriter fileStatistic = new BufferedWriter(new FileWriter(pathname));
        fileStatistic.write(statistic.toString());
        fileStatistic.close();
    }
}
