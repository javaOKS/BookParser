import org.example.BookParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BookParserTest {
    @Test
    public void getTextTest() throws IOException {
        BookParser bookParser = new BookParser();
        File book = new File("src/main/resources/text.txt");
        String str = "cup, fork, bowl, napkin, plate ,knife, cup, fork, bowl, cup, cup, fork!!! ";
        BufferedWriter fileBook = new BufferedWriter(new FileWriter(book));
        fileBook.write(str);
        fileBook.close();
        List<String> words = bookParser.getText(book);
        Assert.assertEquals(12, words.size());
        book.delete();
    }

    @Test
    public void topWordsTest() {
        BookParser bookParser = new BookParser();
        int amount = 4;
        List<String> words = List.of("cup", "fork", "bowl", "napkin", "plate", "knife", "cup", "fork",
                "bowl", "cup", "cup", "fork");
        List<String> expected = List.of("cup", "fork", "bowl", "napkin");
        List<String> result = bookParser.topWords(words, amount);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void uniqueWords() {
        BookParser bookParser = new BookParser();
        List<String> words = List.of("cup", "fork", "bowl", "napkin", "plate", "knife", "cup", "fork",
                "bowl", "cup", "cup", "fork");
        int total = bookParser.uniqueWords(words);
        Assert.assertEquals(6, total);
    }
}
