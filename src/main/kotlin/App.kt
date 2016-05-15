import domain.DIManager
import domain.entity.WordsFrequency
import java.util.*
import kotlin.comparisons.compareBy

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
	words = split(dictionariesDP.getDictionaryStopWords(), words)
	rawText = buildText(words)
	println("$rawText")

	println("****")
	groupe(words)

	println("exit")
}

private fun groupe(words: ArrayList<String>) {
	val list = ArrayList(words)

	var groupBy = list.groupBy { it }
	val mapp = ArrayList<WordsFrequency>()
	groupBy.forEach { mapp.add(WordsFrequency(it.key, it.value.size)) }
	mapp.sort(compareBy<WordsFrequency>({ it.count }, { it.word }))
	mapp.reverse()
	val sb = StringBuilder()
	for (w in mapp) {
		sb.append(w.word).append(" = ").append(w.count).append('\n')
	}
	println("${sb.toString()}")

}

private fun split(dictionaryStopWords: List<String>, words: ArrayList<String>): ArrayList<String> {
	val wordsNew = ArrayList<String>()
	for (index in words.size - 1 downTo 0) {
		val w = words.get(index)
			.trim({ it.isWhitespace() || it.equals(':') || it.equals(',') || it.equals('.') || it.equals(')') || it.equals('(') || it.equals('»') || it.equals('«') })
		var flag = w.isNotEmpty()

		for (dikWord in dictionaryStopWords) {
			if (!flag) {
				break
			}
			flag = !w.equals(dikWord,true)
		}
		if (flag) {
			wordsNew.add(w)
		}
	}
	wordsNew.reverse()
	return wordsNew
}

private fun buildText(words: ArrayList<String>): String {
	val sb = StringBuilder()
	for (w in words) {
		sb.append(w).append(' ')
	}
	return sb.toString()
}

fun split(rawText: String): ArrayList<String> {
	return rawText.split(' ') as ArrayList<String>;
}









