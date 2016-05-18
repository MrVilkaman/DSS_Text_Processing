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
	val text = TextUtils.preProcessText(dictionariesDP.getDictionaryName(),rawText)
	var words = TextUtils.splitByWords(dictionariesDP.getDictionaryStopWords(), text)

	println("Текст без \"мусора\":")
	println(buildText(words, " "))
	println()

	words = TextUtils.postProcessText(words)
	words = TextUtils.stemming(words)

	words = TextUtils.analysWords(words)

	println()
	useGroupe(words)
}

private fun showSentensies(dictionariesDP: DictionariesDPImpl, rawText: String) {
	val sentensies = TextUtils.splitBySentensies(rawText, dictionariesDP.getDictionaryAbbreviations())
	println("Выделениe предложений: ")
	println(buildText(sentensies, "\n*"))
	println("Всего предложений: ${sentensies.size}")
	println("****")
	println()
}


fun useGroupe(words: List<String>) {
	val mapp = TextUtils.groupe(words)
	val sb = StringBuilder()
	sb.append('\n').append("*****").append('\n')
	for (w in mapp) {
		sb.append(w.word).append(" = ").append(w.count).append('\n')
	}
	sb.append("Всего групп: ").append(mapp.size).append('\n')
	println("${sb.toString()}")
}


private fun buildText(words: List<String>, sepor: String): String {
	val sb = StringBuilder()
	for (w in words) {
		sb.append(w).append(sepor)
	}
	return sb.toString()
}










