package howtoprogram.words;

import java.util.LinkedList;
import java.util.List;

/**
 * Generates one-letter variants of a word.
 */
public class WordNode {

    private String word;

    public WordNode(String word) {
        this.word = word;
    }

public List<WordNode> variantsByOneLetter(WordChecker checker) {
    List<WordNode> result = new LinkedList<>();
    //For each position in the word...
    for (int i = 0; i < word.length(); i++) {
        //...add the variants made by changing
        //just the letter at that position.
        addVariantsAtPosition(i, result, checker);
    }
    return result;
}

private void addVariantsAtPosition(int position, List<WordNode> nodes, WordChecker checker) {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    char original = word.charAt(position);
    for (int i = 0; i < alphabet.length(); i++) {
        char fromAlphabet = alphabet.charAt(i);
        if (original != fromAlphabet) {
            StringBuilder sb = new StringBuilder(word);
            sb.deleteCharAt(position);
            sb.insert(position, fromAlphabet);
            String toAdd = sb.toString();
            if (checker.isPreviouslyUnseenValidWord(toAdd)) {
                nodes.add(new WordNode(toAdd));
            }
        }
    }
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordNode wordNode = (WordNode) o;

        return word.equals(wordNode.word);

    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}