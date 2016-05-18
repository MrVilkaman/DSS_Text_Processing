package domain

import domain.entity.WordsFrequency
import domain.entity.revSort
import java.util.*

/**
 * Created by Zahar on 16.05.16.
 */
class TextUtils {
	companion object {

		fun groupe(words: List<String>): List<WordsFrequency> {
			val list = ArrayList(words)

			val groupBy = list.groupBy { it }
			val mapp: ArrayList<WordsFrequency> = ArrayList<WordsFrequency>()
			groupBy.forEach { mapp.add(WordsFrequency(it.key, it.value.size)) }
			mapp.revSort()
//			mapp.removeIf { it.count == 1 }
			return mapp
		}

		fun splitByWords(dictionaryStopWords: List<String>, rawText: String): List<String> {
			val words = TextUtils.split(rawText)
			val wordsNew = ArrayList<String>()
			for (index in words.size - 1 downTo 0) {
				val w = words.get(index)
					.trim({
						it.isWhitespace() || it.equals(':')
							|| it.equals('?')
							|| it.equals(160.toChar())
							|| it.equals('!')
							|| it.equals(',') || it.equals('.') || it.equals(')') || it.equals('(') || it.equals('»') || it.equals('«')
					})
				var flag = w.isNotEmpty()

				for (dikWord in dictionaryStopWords) {
					if (!flag) {
						break
					}
					flag = !w.equals(dikWord, true)
				}
				if (flag) {
					wordsNew.add(w.toLowerCase())
				}
			}
			wordsNew.reverse()
			return wordsNew
		}

		fun splitBySentensies(rawText: String, dictAbb: List<String>): List<String> {
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


			val split: ArrayList<String> = sb.toString().split(carretWord) as ArrayList<String>
			split.removeIf { it.isEmpty() }
			return split
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

		fun stemming(words: List<String>): List<String> {
			val list = ArrayList<String>()
			words.forEach { list.add(Porter.stem(it)) }
			return list;
		}

		fun split(rawText: String): List<String> {
			return rawText.split(' ', 160.toChar());
		}

		fun preProcessText(dictionaryName: List<String>, rawText: String): String {
			val sb = StringBuilder(rawText)
			for (word in dictionaryName) {
				var lastIndex = -1;
				do {
					lastIndex = sb.indexOf(word, lastIndex + 1, true)
					val flag = lastIndex != -1;
					if (flag) {
						sb.insert(lastIndex, "|")
						sb.insert(lastIndex + word.length + 1, "|")
						lastIndex += word.length + 1
					}
				} while (flag)
			}
			return sb.toString()

		}

		fun postProcessText(words: List<String>): List<String> {
			val newWords = ArrayList<String>()
			var inProgres: Boolean = false
			var sb: StringBuilder? = null;
			for (word in words) {
				if (inProgres) {
					if (word.endsWith('|')) {
						if (sb != null) {
							val substring = word.substring(0..word.length - 2)
							sb.append(substring)
							newWords.add(sb.toString())
							sb = null
							inProgres = false
						}
					} else {
						sb?.append(word)?.append(' ')
					}
				} else {
					if (!word.startsWith('|')) {
						newWords.add(word)
					} else {
						sb = StringBuilder()
						sb.append(word.substring(1..word.length - 1)).append(' ')
						inProgres = true
					}
				}
			}
			return newWords

		}

		fun analysWords(words: List<String>): List<String> {
			val ww = ArrayList<String>()
				for (index in 0..words.size - 1) {
					val s = words[index];

					val contains = s.contains('-')

					if(contains){
						var count = 0;
						for(num in s.split('-')){
							val num1 = num.trim('$')
							if (num1.isNum())
								count++;
						}
						if (count == 2)
							ww.add("$s (диапозон)")
						else
							ww.add(s)
					}else {
						 if (s.isNum()) ww.add("$s (число)") else ww.add(s)
					}
				}
			return ww
		}
	}

}

fun String.isNum():Boolean {
	try {
		Integer.parseInt(this)
		return true
	} catch(e: Exception) {
		return false
	}

}
