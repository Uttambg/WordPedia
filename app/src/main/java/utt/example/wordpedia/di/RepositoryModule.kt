package utt.example.wordpedia.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import utt.example.wordpedia.data.repository.DictionaryRepositoryImpl
import utt.example.wordpedia.domain.repository.DictionaryRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindDictionaryRepository(
        dictionaryRepositoryImpl : DictionaryRepositoryImpl
    ) : DictionaryRepository

}