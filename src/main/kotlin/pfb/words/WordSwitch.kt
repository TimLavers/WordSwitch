package pfb.words

/**
 * Implements the Word Switch algorithm.
 */
class WordSwitch(dictionary: Dictionary, start: String, val target: String) {

    val startNode: WordNode
    val checker: WordChecker

    init {
        startNode = WordNode(start)
        checker = WordChecker(dictionary)
    }

fun lookForTarget(): WordNode? {
    //Declare a variable to hold the new words that get created
    //in each generation. Initialise it with the words generated
    //by the start word.
    var currentGeneration = startNode.variantsByOneLetter(checker)
    //Have a loop to create new generations so long as these
    //contain new words and the target is not found.
    var targetNode: WordNode? = null
    while (currentGeneration.isNotEmpty() && targetNode == null) {
        //Create a val to hold the words that will be generated.
        val nextGeneration = mutableListOf<WordNode>()
        //For each word in the current generation...
        for (wordNode in currentGeneration) {
            //...check to see if it is the target...
            if (wordNode.text == target) {
                targetNode = wordNode
            }
            //...and generate all new words from it.
            nextGeneration.addAll(wordNode.variantsByOneLetter(checker))
        }
        //Having dealt with the current generation,
        //replace it by the words it generated.
        currentGeneration = nextGeneration
    }
    return targetNode
}
}