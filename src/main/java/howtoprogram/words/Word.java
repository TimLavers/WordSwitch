package howtoprogram.words;

import java.util.HashSet;
import java.util.Set;

/**
 * An arrangement of characters.
 */
public class Word {

    private String text;

    public Word(String text) {
        this.text = text.toLowerCase();
    }

    public Word reverse1() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char opposite = text.charAt(text.length() - i - 1);
            sb.append(opposite);
        }
        return new Word(sb.toString());
    }

    public Word reverse() {
        int length = text.length();
        //If the word is empty or just one letter, it is its own reverse.
        if (length < 2) {
            return this;
        }
        //Get the first and last characters and the inner word formed
        //by the letters in between these.
        char first = text.charAt(0);
        char last = text.charAt(length - 1);
        Word inner = new Word(text.substring(1, length - 1));
        //Use recursion to get the reverse of the inner word.
        String reverseOfInner = inner.reverse().text();
        //Put the three pieces together to form the result.
        String newText = last + reverseOfInner + first;
        return new Word(newText);
    }

    public boolean isPalindrome() {
        return equals(reverse());
    }

    public String text() {
        return text;
    }

    public Word createNewWord(char newCharacter, int position) {
        StringBuilder sb = new StringBuilder(text);
        sb.insert(position, newCharacter);
        return new Word(sb.toString());
    }

    public Word tail() {
        if (text.isEmpty()) {
            return this;
        }
        return new Word(text.substring(1));
    }

    public Set<Word> permutations() {
        //Create a result set to which the permutations will be added.
        Set<Word> result = new HashSet<>();
        //If the word has length 0 or 1, then the word itself is
        //the only permutation. Add this and return.
        if (text.length() <= 1) {
            result.add(this);
            return result;
        }
        //At this point we know that the length is at least two.
        //Get the first character of the word.
        char head = text.charAt(0);
        //Create a shortened word by removing the first character.
        Word tail = tail();
        //Apply this method recursively to get the permutations
        //of the shortened word.
        Set<Word> tailPermuations = tail.permutations();
        //For each possible insertion position,
        //for each word in the permutations of the shortened word,
        //create a word by inserting the first character at the
        //position, and add this to the result.
        for (int i = 0; i < text.length(); i++) {
            for (Word tailPermutation : tailPermuations) {
                result.add(tailPermutation.createNewWord(head, i));
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return text != null ? text.equals(word.text) : word.text == null;

    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    public String toString() {
        return text;
    }
}