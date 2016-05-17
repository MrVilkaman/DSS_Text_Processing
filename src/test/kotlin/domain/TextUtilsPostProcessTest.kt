package domain

import org.assertj.core.api.Assertions
import org.junit.Test

import java.util.Arrays

/**
 * Created by Zahar on 16.05.16.
 */
class TextUtilsPostProcessTest {

	@Test
	fun testComplex() {
		val words = Arrays.asList("|Magic", "The", "Gathering|", "|Hearthstone", "Heroes", "of", "Warcraft|")

		val wordsqwer: List<String> = TextUtils.postProcessText(words)
		Assertions.assertThat(wordsqwer).contains("Magic The Gathering", "Hearthstone Heroes of Warcraft").hasSize(2)
	}

	@Test
	fun testComplex2() {
		val words = Arrays.asList("qwer", "asdf", "|qwer", "or", "qwer|", "zxc")

		val wordsqwer = TextUtils.postProcessText(words)
		Assertions.assertThat(wordsqwer).contains("qwer", "asdf", "qwer or qwer", "zxc").hasSize(4)
	}
}
