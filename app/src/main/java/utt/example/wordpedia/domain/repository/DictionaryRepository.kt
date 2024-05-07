package utt.example.wordpedia.domain.repository

import kotlinx.coroutines.flow.Flow
import utt.example.wordpedia.domain.model.WordItem
import utt.example.wordpedia.util.Result

interface DictionaryRepository {

        suspend fun getWordResult(
            word : String
        ) : Flow<Result<WordItem>>
}

