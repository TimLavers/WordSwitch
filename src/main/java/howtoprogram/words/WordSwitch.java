package howtoprogram.words;

public class WordSwitch {

    private WordNode startWordNode;
    private WordChecker checker;
    private String wordToFind;

    public WordSwitch(Dictionary dictionary, String startWord, String wordToFind) {
        startWordNode = new WordNode(startWord);
        checker = new WordChecker(dictionary);
        this.wordToFind = wordToFind;
    }

    public WordNode lookForTarget() {
        //Declare a variable to hold the new words that get created
        //in each generation. Initialise it with the words generated
        //by the start word.

        //Have a loop to create new generations so long as these
        //contain new words and the target is not found.

        return null;
    }
}