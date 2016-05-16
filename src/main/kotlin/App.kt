import domain.DIManager
import domain.Porter
import domain.entity.WordsFrequency
import domain.entity.revSort
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
	splitBySentensies(rawText, dictionariesDP.getDictionaryAbbreviations())
//	words = split(dictionariesDP.getDictionaryStopWords(), words)
//	rawText = buildText(words)
//	println("$rawText")
//
//	println("****")
//	words = stemming(words)
//	groupe(words)

	println("exit")
}

fun splitBySentensies(rawText: String, dictAbb: List<String>) {
	val carretWord = "\n*"

	val sb = StringBuilder(rawText)
	var lastIndex = -1;
	val listChars = Arrays.asList('.', '!', '?')
	for (ch in listChars)
		do {
			lastIndex = sb.indexOf(ch, lastIndex + 1)
			val flag = lastIndex != -1;
			if (flag) {
				sb.insert(lastIndex + 1, carretWord)
			}
		} while (flag)

	lastIndex = -1
	do {
		lastIndex = sb.indexOf(carretWord, lastIndex + 1)
		for (word in dictAbb) {

			val flag = matchStr(sb, lastIndex, word);
			if (flag) {
				sb.replace(lastIndex, lastIndex + carretWord.length, "")
				break
			}
		}
	} while (lastIndex != -1)


	println(sb.toString())
}

fun matchStr(sb: StringBuilder, lastIndex: Int, word: String): Boolean {
	val length = word.length
	var startIndex = lastIndex - length * 2
	startIndex = if (startIndex < 0) 0 else startIndex
	for (strIndex in startIndex..lastIndex) {
		var flag = false
		for (wordIndex in 0..length - 1) {
			val c = sb[strIndex + wordIndex]
			val c1 = word[wordIndex]
			if (c == c1) {
				flag = true
			} else {
				flag = false
				break
			}
		}
		if (flag) return true
	}
	return false
}

fun stemming(words: ArrayList<String>): ArrayList<String> {
	val list = ArrayList<String>()
	words.forEach { list.add(Porter.stem(it)) }
	return list;
}

private fun groupe(words: ArrayList<String>) {
	val list = ArrayList(words)

	var groupBy = list.groupBy { it }
	val mapp: ArrayList<WordsFrequency> = ArrayList<WordsFrequency>()
	groupBy.forEach { mapp.add(WordsFrequency(it.key, it.value.size)) }
	mapp.revSort()
	mapp.removeIf { it.count == 1 }

	val sb = StringBuilder()
	for (w in mapp) {
		sb.append(w.word).append(" = ").append(w.count).append('\n')
	}
	sb.append("Всего групп: ").append(mapp.size).append('\n')
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
			flag = !w.equals(dikWord, true)
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









