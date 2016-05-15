import domain.DIManager
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
	var words = split(rawText)


	val dictionaryStopWords = dictionariesDP.getDictionaryStopWords()
	for (index in words.size - 1 downTo 0) {
		val w = words.get(index)
		for (dikWord in dictionaryStopWords) {
			if (w.equals(dikWord)) {
				words.removeAt(index)
				continue
			}

		}
	}

	rawText = buildText(rawText, words)
	println("$rawText")


	println("exit")
}

private fun buildText(rawText: String, words: ArrayList<String>): String {
	var rawText1 = rawText
	val sb = StringBuilder()
	for (w in words) {
		sb.append(w).append(' ')
	}
	rawText1 = sb.toString()
	return rawText1
}

fun split(rawText: String): ArrayList<String> {
	return rawText.split(' ') as ArrayList<String>;
}









