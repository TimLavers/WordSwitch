package pfb.words.test

import org.junit.Assert
import org.junit.Test
import pfb.words.Dictionary
import java.nio.file.Paths
import pfb.words.WordChecker

class WordCheckerTest {
    @Test
    fun notInDictionaryTest() {
        val path = Paths.get("src/test/resources/books/FiveWords.txt")
        val dictionary = Dictionary(path)
        val checker = WordChecker(dictionary)
        Assert.assertFalse(checker.isPreviouslyUnseenValidWord("aardworlff"))
    }

    @Test
    fun validWordTest() {
        val path = Paths.get("src/test/resources/books/FiveWords.txt")
        val dictionary = Dictionary(path)
        val checker = WordChecker(dictionary)
        Assert.assertTrue(checker.isPreviouslyUnseenValidWord("bat"))
        Assert.assertFalse(checker.isPreviouslyUnseenValidWord("bat"))
    }
}