package domain.entity

import java.util.*
import kotlin.comparisons.compareBy

/**
 * Created by Zahar on 15.05.16.
 */
data class WordsFrequency(val word:String,val count:Int)

fun ArrayList<WordsFrequency>.revSort() {
	sort(compareBy<WordsFrequency>({ it.count }, { it.word }))
	reverse()
}