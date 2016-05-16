import datalayer.providers.DictionariesDPImpl
import domain.DIManager
import domain.TextUtils
import java.util.*

/**
 * Created by Zahar on 17.04.16.
 */

fun main(args: Array<String>) {
	val textDP = DIManager.getTextDP()
	println("Название: \"${textDP.getRawTextTitle()}\"")
	println("Ссылка: \"${textDP.getTextLink()}\"")
	println()

	val dictionariesDP = DIManager.getDictionariesDP()


	var rawText = textDP.getRawText()
	showSentensies(dictionariesDP, rawText)

	showWordsHandle(dictionariesDP, rawText)

	println("exit")
}

private fun showWordsHandle(dictionariesDP: DictionariesDPImpl, rawText: String) {
	var words = TextUtils.splitByWords(dictionariesDP.getDictionaryStopWords(), rawText)
	println("Текст без \"мусора\":")
	println()
	println(buildText(words))
	words = TextUtils.stemming(words)
	useGroupe(words)
}

private fun showSentensies(dictionariesDP: DictionariesDPImpl, rawText: String) {
	val sentensies = TextUtils.splitBySentensies(rawText, dictionariesDP.getDictionaryAbbreviations())
	println("Выделенеи предложений: ")
	println(sentensies)
	println("****")
	println()
}


fun useGroupe(words: ArrayList<String>) {
	val mapp = TextUtils.groupe(words)
	val sb = StringBuilder()
	sb.append('\n').append("*****").append('\n')
	for (w in mapp) {
		sb.append(w.word).append(" = ").append(w.count).append('\n')
	}
	sb.append("Всего групп: ").append(mapp.size).append('\n')
	println("${sb.toString()}")
}


private fun buildText(words: ArrayList<String>): String {
	val sb = StringBuilder()
	for (w in words) {
		sb.append(w).append(' ')
	}
	return sb.toString()
}










