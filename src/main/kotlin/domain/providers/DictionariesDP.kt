package domain.providers

/**
 * Created by Zahar on 15.05.16.
 */
interface DictionariesDP {

	open fun getDictionaryAbbreviations():List<String>;
	open fun getDictionaryStopWords(): List<String>
}