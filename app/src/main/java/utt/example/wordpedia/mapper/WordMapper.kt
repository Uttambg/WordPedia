package utt.example.wordpedia.mapper

import utt.example.wordpedia.data.dto.DefinitionDto
import utt.example.wordpedia.data.dto.MeaningDto
import utt.example.wordpedia.data.dto.WordItemDto
import utt.example.wordpedia.domain.model.Definition
import utt.example.wordpedia.domain.model.Meaning
import utt.example.wordpedia.domain.model.WordItem

fun WordItemDto.toWordItem() = WordItem (
    word = word ?: "",
    meanings = meanings?.map {
        it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetic ?: ""
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech ?: ""
)


fun definitionDtoToDefinition(
    definitionDto: DefinitionDto?
) = Definition(
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: ""
)