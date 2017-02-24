package pfb.words

/**
 * Checks that potential new words are in the dictionary
 * and have not previously been seen.
 */
class WordChecker(val dictionary: Dictionary) {

    val wordsSoFar = mutableSetOf<String>()

fun isPreviouslyUnseenValidWord(string: String): Boolean {
    if (!dictionary.contains(string)) {
        return false
    }
    if (wordsSoFar.contains(string)) {
        return false
    }
    wordsSoFar.add(string)
    return true
}
}