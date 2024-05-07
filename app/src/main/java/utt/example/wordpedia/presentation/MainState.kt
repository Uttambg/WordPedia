package utt.example.wordpedia.presentation

import utt.example.wordpedia.domain.model.WordItem

data class MainState(
    val isLoading : Boolean = false,

    val searchWord : String = "",
    val wordItem : WordItem? = null
)