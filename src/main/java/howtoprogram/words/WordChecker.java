package howtoprogram.words;

import java.util.HashSet;
import java.util.Set;

/**
 * Checks that potential new words are in the dictionary
 * and have not previously been seen.
 */
public class WordChecker {

    private Dictionary dictionary;
    private Set<String> wordsSoFar = new HashSet<>();

    public WordChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isPreviouslyUnseenValidWord(String word) {
        if (!dictionary.contains(word)) {
            return false;
        }
        if (wordsSoFar.contains(word)) {
            return false;
        }
        wordsSoFar.add(word);
        return true;
    }
}
