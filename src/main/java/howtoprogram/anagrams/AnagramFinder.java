package howtoprogram.anagrams;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

/**
 * Finds the anagrams of a word.
 */
public class AnagramFinder {

    public static void main(String[] args) throws IOException {
        //Create a dictionary from the "english.txt" file in resources/books
        Path path = Paths.get("src/main/resources/books/english.txt");
        FileBasedDictionary dictionary = new FileBasedDictionary(path);
        //Create a Word from some initial English word.
        String str = "regal";
        if (!dictionary.contains(str)) {
            System.out.println("Not in dictionary: " + str);
        }
        Word word = new Word(str);
        //Get all rearrangements of the letters in this word.
        Set<Word> anagrams = word.permutations();
        //For each of these...
        for (Word w : anagrams) {
            //...if it is in the dictionary...
            if (dictionary.contains(w.text())) {
                //...print it out.
                System.out.println(w.text());
            }
        }
    }
}