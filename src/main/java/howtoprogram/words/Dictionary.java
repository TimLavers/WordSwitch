package howtoprogram.words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Checks words for inclusion in a list of words read from a file.
 * The file format is one word per line.
 */
public class Dictionary {
    private Set<String> words = new HashSet<>();

    public Dictionary(Path pathToFile) throws IOException {
        List<String> lines = Files.readAllLines(pathToFile);
        for (String line : lines) {
            words.add(line);
        }
    }

    public Set<String> allWords() {
        return words;
    }

    public boolean contains(String string) {
        return words.contains(string);
    }
}