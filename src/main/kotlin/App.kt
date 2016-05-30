import datalayer.providers.DictionariesDPImpl
import domain.DIManager
import domain.TextUtils
import domain.entity.WordsFrequency


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

	showWordRateInSentensies(dictionariesDP, rawText)

	println("exit")
}

private fun showWordRateInSentensies(dictionariesDP: DictionariesDPImpl, rawText: String) {
	val list = TextUtils.getWordsPairs(dictionariesDP, rawText)

	val mapp = TextUtils.sortByFrequency(TextUtils.groupPairs(list))
	println("Совместное использование слова в предложении: ")
	printGroup(mapp)
}

private fun showWordsHandle(dictionariesDP: DictionariesDPImpl, rawText: String) {
	val text = TextUtils.preProcessText(dictionariesDP.getDictionaryName(), rawText)
	var words = TextUtils.splitByWords(dictionariesDP.getDictionaryStopWords(), text)

	println("Текст без \"мусора\":")
	println(buildText(words, " "))
	println()

	words = TextUtils.postProcessText(words)
	words = TextUtils.stemming(words)

	words = TextUtils.analysWords(words)

	println()
	printGroup(TextUtils.groupe(words))
}

private fun showSentensies(dictionariesDP: DictionariesDPImpl, rawText: String) {
	val sentensies = TextUtils.splitBySentensies(rawText, dictionariesDP.getDictionaryAbbreviations())
	println("Выделениe предложений: ")
	println(buildText(sentensies, "\n*"))
	println("Всего предложений: ${sentensies.size}")
	println("****")
	println()
}

fun printGroup(mapp: List<WordsFrequency>) {
	val sb = StringBuilder()
	sb.append('\n').append("*****").append('\n')
	val size = mapp.size.toFloat()
	for (w in mapp) {
		val fl = w.count / size
		sb.append(w.word).append(" = ").append(w.count).append(" (${fl.format(4)})").append('\n')
	}
	sb.append("Всего групп: ").append(size).append('\n')
	println("${sb.toString()}")
}

fun Float.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

private fun buildText(words: List<String>, sepor: String): String {
	val sb = StringBuilder()
	for (w in words) {
		sb.append(w).append(sepor)
	}
	return sb.toString()
}










