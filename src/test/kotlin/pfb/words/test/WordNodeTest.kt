package pfb.words.test

import org.junit.Assert
import org.junit.Test
import pfb.words.Dictionary
import pfb.words.WordChecker
import pfb.words.WordNode
import java.nio.file.Paths

class WordNodeTest {
    @Test
    fun testEmpty() {
        val checker = wordChecker()
        val wordNode = WordNode("")
        Assert.assertTrue(wordNode.variantsByOneLetter(checker).isEmpty())
    }

    @Test
    fun testOneLetterWord() {
        val checker = wordChecker()
        val nodeA = WordNode("a")
        val generated = nodeA.variantsByOneLetter(checker)
        Assert.assertEquals(3, generated.size.toLong())
        Assert.assertTrue(generated.contains(WordNode("b")))
        Assert.assertTrue(generated.contains(WordNode("c")))
        Assert.assertTrue(generated.contains(WordNode("d")))
    }

    @Test
    fun testTwoLetterWord() {
        val checker = wordChecker()
        val nodeA = WordNode("ab")
        val generated = nodeA.variantsByOneLetter(checker)
        Assert.assertEquals(6, generated.size.toLong())
        Assert.assertTrue(generated.contains(WordNode("aa")))
        Assert.assertTrue(generated.contains(WordNode("ac")))
        Assert.assertTrue(generated.contains(WordNode("ad")))
        Assert.assertTrue(generated.contains(WordNode("bb")))
        Assert.assertTrue(generated.contains(WordNode("cb")))
        Assert.assertTrue(generated.contains(WordNode("db")))
    }

    private fun wordChecker(): WordChecker {
        val path = Paths.get("src/test/resources/books/abcd.txt")
        val dictionary = Dictionary(path)
        val checker = WordChecker(dictionary)
        return checker
    }
}