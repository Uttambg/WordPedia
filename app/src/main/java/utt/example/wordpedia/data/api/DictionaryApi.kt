package utt.example.wordpedia.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import utt.example.wordpedia.data.dto.WordResultDto

interface DictionaryApi {

    @GET("{word}")
    suspend fun getWordResult(
        @Path("word") word: String
    ): WordResultDto?

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
    }

}