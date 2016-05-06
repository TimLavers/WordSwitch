package howtoprogram.words.test;

import howtoprogram.words.Dictionary;
import howtoprogram.words.WordChecker;
import howtoprogram.words.WordNode;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordNodeTest {
    @Test
    public void testEmpty() throws Exception {
        WordChecker checker = getWordChecker();
        WordNode wordNode = new WordNode("");
        Assert.assertTrue(wordNode.variantsByOneLetter(checker).isEmpty());
    }

    private WordChecker getWordChecker() throws IOException {
        Path path = Paths.get("src/test/resources/books/abcd.txt");
        Dictionary dictionary = new Dictionary(path);
        return new WordChecker(dictionary);
    }

    @Test
    public void testOneLetterWord() throws Exception {
        WordChecker checker = getWordChecker();
        WordNode nodeA = new WordNode("a");
        List<WordNode> generated = nodeA.variantsByOneLetter(checker);
        Assert.assertEquals(3, generated.size());
        Assert.assertTrue(generated.contains(new WordNode("b")));
        Assert.assertTrue(generated.contains(new WordNode("c")));
        Assert.assertTrue(generated.contains(new WordNode("d")));
    }

@Test
public void testTwoLetterWord() throws Exception {
    WordChecker checker = getWordChecker();
    WordNode nodeA = new WordNode("ab");
    List<WordNode> generated = nodeA.variantsByOneLetter(checker);
    Assert.assertEquals(6, generated.size());
    Assert.assertTrue(generated.contains(new WordNode("bb")));
    Assert.assertTrue(generated.contains(new WordNode("cb")));
    Assert.assertTrue(generated.contains(new WordNode("db")));
    Assert.assertTrue(generated.contains(new WordNode("aa")));
    Assert.assertTrue(generated.contains(new WordNode("ac")));
    Assert.assertTrue(generated.contains(new WordNode("ad")));
}
}
