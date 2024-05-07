package utt.example.wordpedia.presentation

sealed class MainUiEvents {

    data class OnSearchWordChange(val newWord : String) : MainUiEvents()

    object OnSearchClick : MainUiEvents()
}