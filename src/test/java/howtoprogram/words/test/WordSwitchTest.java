package howtoprogram.words.test;

import howtoprogram.words.Dictionary;
import howtoprogram.words.WordSwitch;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class WordSwitchTest {
    @Test
    public void noPathDifferentLengths() throws Exception {
        Path path = Paths.get("src/test/resources/books/abcd.txt");
        Dictionary dictionary = new Dictionary(path);
        WordSwitch wordSwitch = new WordSwitch(dictionary, "ab", "abc");
        Assert.assertNull(wordSwitch.lookForTarget());
    }

    @Test
    public void noPathTargetNotInDictionary() throws Exception {
        Path path = Paths.get("src/test/resources/books/abcd.txt");
        Dictionary dictionary = new Dictionary(path);
        WordSwitch wordSwitch = new WordSwitch(dictionary, "aa", "ae");
        Assert.assertNull(wordSwitch.lookForTarget());
    }
}
