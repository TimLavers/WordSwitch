package howtoprogram.anagrams;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Finds all palindromes in a dictionary.
 */
public class PalindromeFinder {

    public static void main(String[] args) throws IOException {
        //Create a dictionary from the "english.txt" file in resources/books
        Path path = Paths.get("src/main/resources/books/english.txt");
        FileBasedDictionary dictionary = new FileBasedDictionary(path);
        //For each string in the dictionary...
        for (String string : dictionary.allWords()) {
            //...create a Word from the string...
            Word word = new Word(string);
            //...test to see if the word is a palindrome...
            if (word.isPalindrome()) {
                //...if it is, print it out.
                System.out.println(string);
            }
        }
    }
}