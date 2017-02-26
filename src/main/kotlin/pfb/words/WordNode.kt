package pfb.words

/**
 * Generates one-letter variants of a word.
 */
data class WordNode(val text: String) {
    fun variantsByOneLetter(checker: WordChecker): List<WordNode> {
        val result = mutableListOf<WordNode>()
        //For each position in the word...
        for (i in 0..text.length - 1) {
            //...add the variants made by changing
            //just the letter at that position.
            addVariantsAtPosition(i, result, checker)
        }
        return result
    }

    private fun addVariantsAtPosition(position: Int, nodes: MutableList<WordNode>, checker: WordChecker) {
        val textBeforePosition = text.substring(0, position)
        val textAfterPosition = if (text.length > 1) text.substring(position + 1, text.length) else ""
        val originalLetter = text[position]
        for (fromAlphabet in "abcdefghijklmnopqrstuvwxyz") {
            if (originalLetter != fromAlphabet) {
                val variant = textBeforePosition + fromAlphabet + textAfterPosition
                if (checker.isPreviouslyUnseenValidWord(variant)) {
                    nodes.add(WordNode(variant))
                }
            }
        }
    }
}