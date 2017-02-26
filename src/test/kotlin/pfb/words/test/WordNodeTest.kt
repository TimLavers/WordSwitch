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
Assert.assertTrue(generated.contains(WordNode("b", nodeA)))
Assert.assertTrue(generated.contains(WordNode("c", nodeA)))
Assert.assertTrue(generated.contains(WordNode("d", nodeA)))
    }

@Test
fun testTwoLetterWord() {
    val checker = wordChecker()
    val nodeAB = WordNode("ab")
    val generated = nodeAB.variantsByOneLetter(checker)
    Assert.assertEquals(6, generated.size.toLong())
    Assert.assertTrue(generated.contains(WordNode("aa", nodeAB)))
    Assert.assertTrue(generated.contains(WordNode("ac", nodeAB)))
    Assert.assertTrue(generated.contains(WordNode("ad", nodeAB)))
    Assert.assertTrue(generated.contains(WordNode("bb", nodeAB)))
    Assert.assertTrue(generated.contains(WordNode("cb", nodeAB)))
    Assert.assertTrue(generated.contains(WordNode("db", nodeAB)))
}

    private fun wordChecker(): WordChecker {
        val path = Paths.get("src/test/resources/books/abcd.txt")
        val dictionary = Dictionary(path)
        val checker = WordChecker(dictionary)
        return checker
    }
}