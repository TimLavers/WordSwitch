package pfb.words.test

import org.junit.Assert
import org.junit.Test
import pfb.words.Dictionary
import pfb.words.WordChecker
import pfb.words.WordNode
import java.nio.file.Paths
import pfb.words.WordSwitch

class WordSwitchTest {
    @Test
    fun noPathDifferentLengths() {
        val wordSwitch = WordSwitch(dictionary(), "ab", "abc")
        Assert.assertNull(wordSwitch.lookForTarget())
    }

    @Test
    fun noPathTargetNotInDictionary() {
        val dictionary = dictionary()
        val wordSwitch = WordSwitch(dictionary, "aa", "ae")
        Assert.assertNull(wordSwitch.lookForTarget())
    }

    @Test
    fun a_to_b() {
        val wordSwitch = WordSwitch(dictionary(), "a", "b")
        val result = wordSwitch.lookForTarget()
        Assert.assertEquals("b", result!!.text)
    }

    @Test
    fun ab_to_ba() {
        val wordSwitch = WordSwitch(dictionary(), "ab", "ba")
        val result = wordSwitch.lookForTarget()
        Assert.assertEquals("ba", result!!.text)
    }

    private fun dictionary(): Dictionary {
        val path = Paths.get("src/test/resources/books/abcd.txt")
        val dictionary = Dictionary(path)
        return dictionary
    }
}