package utt.example.wordpedia.data.repository

import android.app.Application

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import utt.example.wordpedia.R
import utt.example.wordpedia.data.api.DictionaryApi
import utt.example.wordpedia.domain.model.WordItem
import utt.example.wordpedia.domain.repository.DictionaryRepository
import utt.example.wordpedia.mapper.toWordItem
import utt.example.wordpedia.util.Result
import java.io.IOException
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val application: Application
) : DictionaryRepository {

    override suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>> {
        return flow {
            emit(Result.Loading(true))

            val remoteWordResultDto = try {
                dictionaryApi.getWordResult(word)
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_t_get_result)))
                emit(Result.Loading(false))
                return@flow
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_t_get_result)))
                emit(Result.Loading(false))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_t_get_result)))
                emit(Result.Loading(false))
                return@flow
            }

            remoteWordResultDto?.let { wordResultDto ->
                wordResultDto[0]?.let { wordItemDto ->
                    emit(Result.Success(wordItemDto.toWordItem()))
                    emit(Result.Loading(false))
                    return@flow
                }
            }

            emit(Result.Error(application.getString(R.string.can_t_get_result)))
            emit(Result.Loading(false))
        }
    }
}