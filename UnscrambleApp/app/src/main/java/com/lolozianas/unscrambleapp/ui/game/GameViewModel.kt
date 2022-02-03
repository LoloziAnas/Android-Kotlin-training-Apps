package com.lolozianas.unscrambleapp.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/** [GameViewModel] a viewModel containing the app data and methods to process the data */
class GameViewModel : ViewModel() {

    /** Declare a private mutable variable {@param _score} that can only modifier within the class
     * it is declared */
    private var _score = MutableLiveData(0)

    /** Declare a public immutable variable that can be access to it outside this class*/
    val score: LiveData<Int> get() = _score

    private var _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int> get() = _currentWordCount

    private var _currentScrambleWord = MutableLiveData<String>()
    val currentScrambleWord: LiveData<String> get() = _currentScrambleWord

    private lateinit var currentWord: String

    // Hold the words that already used in the game
    private var wordsList: MutableList<String> = mutableListOf()

    init {
        getNextWord()
    }

    /*
     * Updates currentWord and currentScrambledWord with the next word.
     */
    private fun getNextWord() {
        // Gets a random word from the words list
        currentWord = allWordsList.random()
        // Convert the word to array's char
        val tempWord = currentWord.toCharArray()
        // Shuffled the array
        tempWord.shuffle()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        // Test if the word if already in the words List
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            Log.d("Unscramble", "getNextWord: currentWord: $currentWord")
            // Sets the shuffled Word
            _currentScrambleWord.value = String(tempWord)
            // Increment the Word count
            _currentWordCount.value = _currentWordCount.value?.inc()
            // Add the currentWord to words List that already displayed
            wordsList.add(currentWord)
        }
    }

    /*
    * Return true if the player's word is correct
    * And increment the score accordingly
    * */
    fun isUserCurrentWord(playerWord: String): Boolean {
        return if (playerWord.equals(currentWord, false)) {
            increaseScore()
            true
        } else false
    }

    /*
    * Increase the game's score if the player's word correct
    * */
    private fun increaseScore() {
        _score.value = _score.value?.plus(SCORE_INCREASE)
    }

    /*
    * Return true if the current word count is less the MAX_NO_OF_WORDS
    * */
    fun nextWord(): Boolean {
        return if (_currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    /*
      re-initialize the game data to restart the game
      */
    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }

}