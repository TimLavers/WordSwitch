package howtoprogram.anagrams.test;


import howtoprogram.anagrams.Dictionary;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class DictionaryTest {
    @Test
    public void allWordsTest() throws IOException {
        Path path = Paths.get("src/test/resources/books/FiveWords.txt");
        Dictionary dictionary = new Dictionary(path);
        Set<String> set = dictionary.allWords();
        Assert.assertTrue(set.contains("aardvark"));
        Assert.assertTrue(set.contains("bat"));
        Assert.assertTrue(set.contains("cat"));
        Assert.assertTrue(set.contains("dog"));
        Assert.assertTrue(set.contains("eel"));
        Assert.assertFalse(set.contains("aardwolf"));
        Assert.assertFalse(set.contains("zebra"));
    }

    @Test
    public void containsTest() throws IOException {
        Path path = Paths.get("src/test/resources/books/FiveWords.txt");
        Dictionary dictionary = new Dictionary(path);
        Assert.assertTrue(dictionary.contains("aardvark"));
        Assert.assertTrue(dictionary.contains("bat"));
        Assert.assertTrue(dictionary.contains("cat"));
        Assert.assertTrue(dictionary.contains("dog"));
        Assert.assertTrue(dictionary.contains("eel"));
        Assert.assertFalse(dictionary.contains("aardwolf"));
        Assert.assertFalse(dictionary.contains("zebra"));
    }
}