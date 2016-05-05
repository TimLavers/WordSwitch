package howtoprogram.words.test;

import howtoprogram.words.Word;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class WordTest {

    @Test
    public void isPalindromeTest() {
        Assert.assertTrue(new Word("").isPalindrome());
        Assert.assertTrue(new Word("a").isPalindrome());
        Assert.assertTrue(new Word("aa").isPalindrome());
        Assert.assertTrue(new Word("aaa").isPalindrome());
        Assert.assertTrue(new Word("madam").isPalindrome());
        Assert.assertFalse(new Word("ab").isPalindrome());
    }

    @Test
    public void reverseTest() {
        Assert.assertEquals(new Word(""), new Word("").reverse());
        Assert.assertEquals(new Word("a"), new Word("a").reverse());
        Assert.assertEquals(new Word("ba"), new Word("ab").reverse());
        Assert.assertEquals(new Word("cba"), new Word("abc").reverse());
        Assert.assertEquals(new Word("dcba"), new Word("abcd").reverse());
        Assert.assertEquals(new Word("bbaa"), new Word("aabb").reverse());
    }

    @Test
    public void abcdeTest() {
        Assert.assertEquals(new Word("edcba"), new Word("abcde").reverse());
    }

    @Test
    public void abcdefTest() {
        Assert.assertEquals(new Word("fedcba"), new Word("abcdef").reverse());
    }

    @Test
    public void textTest() {
        Assert.assertEquals("", new Word("").text());
        Assert.assertEquals("hello", new Word("hello").text());
    }

    @Test
    public void isLowerCase() {
        Assert.assertEquals("hello", new Word("Hello").text());
    }

    @Test
    public void tailTest() {
        Word empty = new Word("");
        Assert.assertEquals(empty, empty.tail());
        Word a = new Word("a");
        Assert.assertEquals(empty, a.tail());
        Word anaconda = new Word("anaconda");
        Assert.assertEquals(new Word("naconda"), anaconda.tail());
    }

    @Test
    public void createNewWordFromEmptyTest() {
        Word empty = new Word("");
        Assert.assertEquals(new Word("a"), empty.createNewWord('a', 0));
    }

    @Test
    public void createNewWordFromLengthOneWord() {
        Word x = new Word("x");
        Assert.assertEquals(new Word("ax"), x.createNewWord('a', 0));
        Assert.assertEquals(new Word("xa"), x.createNewWord('a', 1));
    }

    @Test
    public void createNewWordFromLengthTwoWord() {
        Word ab = new Word("ab");
        Assert.assertEquals(new Word("lab"), ab.createNewWord('l', 0));
        Assert.assertEquals(new Word("alb"), ab.createNewWord('l', 1));
        Assert.assertEquals(new Word("abl"), ab.createNewWord('l', 2));
    }

    @Test
    public void createNewWordTest() {
        Word xyz = new Word("xyz");
        Assert.assertEquals(new Word("axyz"), xyz.createNewWord('a', 0));
        Assert.assertEquals(new Word("xayz"), xyz.createNewWord('a', 1));
        Assert.assertEquals(new Word("xyaz"), xyz.createNewWord('a', 2));
        Assert.assertEquals(new Word("xyza"), xyz.createNewWord('a', 3));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertTrue(new Word("Fox").hashCode() == new Word("fox").hashCode());
    }

    @Test
    public void equalsTest() {
        //Exactly the same word.
        Assert.assertTrue(new Word("fox").equals(new Word("fox")));
        //Difference of case only.
        Assert.assertTrue(new Word("Fox").equals(new Word("fox")));
        //Different words
        Assert.assertFalse(new Word("cat").equals(new Word("fox")));
    }

    @Test
    public void permutationsWhenEmpty() {
        Word empty = new Word("");
        Set<Word> permutations = empty.permutations();
        Assert.assertEquals(1, permutations.size());
        Assert.assertTrue(permutations.contains(new Word("")));
    }

    @Test
    public void permutationsFromLengthOneWord() {
        Word a = new Word("a");
        Set<Word> permutations = a.permutations();
        Assert.assertEquals(1, permutations.size());
        Assert.assertTrue(permutations.contains(new Word("a")));
    }

    @Test
    public void permutationsFromLengthTwoWord() {
        Word ab = new Word("ab");
        Set<Word> permutations = ab.permutations();
        Assert.assertEquals(2, permutations.size());
        Assert.assertTrue(permutations.contains(new Word("ab")));
        Assert.assertTrue(permutations.contains(new Word("ba")));
    }

    @Test
    public void permutationsFromLengthThreeWord() {
        Word ab = new Word("abc");
        Set<Word> permutations = ab.permutations();
        Assert.assertEquals(6, permutations.size());
        Assert.assertTrue(permutations.contains(new Word("abc")));
        Assert.assertTrue(permutations.contains(new Word("acb")));
        Assert.assertTrue(permutations.contains(new Word("bac")));
        Assert.assertTrue(permutations.contains(new Word("bca")));
        Assert.assertTrue(permutations.contains(new Word("cab")));
        Assert.assertTrue(permutations.contains(new Word("cba")));
    }

    @Test
    public void permutationsWithRepeatedLetters() {
        Word abba = new Word("abba");
        //aabb, abab, abba, baab, baba, bbaa
        Set<Word> permutations = abba.permutations();
        Assert.assertEquals(6, permutations.size());
        Assert.assertTrue(permutations.contains(new Word("aabb")));
        Assert.assertTrue(permutations.contains(new Word("abab")));
        Assert.assertTrue(permutations.contains(new Word("abba")));
        Assert.assertTrue(permutations.contains(new Word("baab")));
        Assert.assertTrue(permutations.contains(new Word("baba")));
        Assert.assertTrue(permutations.contains(new Word("bbaa")));
    }
}