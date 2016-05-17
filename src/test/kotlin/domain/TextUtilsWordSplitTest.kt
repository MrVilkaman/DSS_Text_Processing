package domain

import org.assertj.core.api.Assertions
import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by Zahar on 16.05.16.
 */
class TextUtilsWordSplitTest {

	@Test
	fun testComplex() {
		val rawText = "qwer asdf |qwer or qwer| zxc"
		//
		val strings = TextUtils.splitByWords(emptyList<String>(), rawText)
		Assertions.assertThat(strings).contains("qwer", "asdf", "|qwer", "or", "qwer|", "zxc").hasSize(6)
	}

	@Test
	fun testRemoveStopWords() {
		val rawText = "qwer asdf qwer or qwer zxc"
		val dictionaryStopWords = Arrays.asList("or", "zxc")
		//
		val strings = TextUtils.splitByWords(dictionaryStopWords, rawText)
		Assertions.assertThat(strings).contains("qwer", "asdf", "qwer", "qwer").hasSize(4)
	}

	@Test
	fun testSimpleSplit() {
		val rawText = "qwer asdf qwer qwer zxc"
		//
		val strings = TextUtils.splitByWords(emptyList<String>(), rawText)
		Assertions.assertThat(strings).contains("qwer", "asdf", "qwer", "qwer", "zxc").hasSize(5)
	}

	@Test
	fun testSimpleSplit2() {
		val rawText = "qwer! asdf? qwer. qwer) (zxc"
		//
		val strings = TextUtils.splitByWords(emptyList<String>(), rawText)
		Assertions.assertThat(strings).contains("qwer", "asdf", "qwer", "qwer", "zxc").hasSize(5)
	}

	@Test
	fun testChar160Trim() {
		val rawText = "qwer${160.toChar()}asdf${160.toChar()}qwer${160.toChar()}or${160.toChar()}qwer zxc"
		val strings = TextUtils.splitByWords(emptyList<String>(), rawText)
		Assertions.assertThat(strings).contains("qwer", "asdf", "qwer", "qwer", "zxc","or").hasSize(6)
	}
}
