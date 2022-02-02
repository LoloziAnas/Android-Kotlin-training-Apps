package com.lolozianas.unscrambleapp.ui.game

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

    private var _currentScrambleWord = MutableLiveData("test")
    val currentScrambleWord: LiveData<String> get() = _currentScrambleWord
}