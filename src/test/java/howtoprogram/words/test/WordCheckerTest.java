package howtoprogram.words.test;

import howtoprogram.words.Dictionary;
import howtoprogram.words.WordChecker;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordCheckerTest {
    @Test
    public void invalidWordTest() throws IOException {
        Path path = Paths.get("src/test/resources/books/FiveWords.txt");
        Dictionary dictionary = new Dictionary(path);
        WordChecker checker = new WordChecker(dictionary);
        Assert.assertFalse(checker.isPreviouslyUnseenValidWord("aardwolf"));
    }

    @Test
    public void validWordTest() throws IOException {
        Path path = Paths.get("src/test/resources/books/FiveWords.txt");
        Dictionary dictionary = new Dictionary(path);
        WordChecker checker = new WordChecker(dictionary);
        Assert.assertTrue(checker.isPreviouslyUnseenValidWord("bat"));
        Assert.assertFalse(checker.isPreviouslyUnseenValidWord("bat"));
    }
}
