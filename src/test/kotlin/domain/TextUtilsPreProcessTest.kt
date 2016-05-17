package domain

import org.junit.Assert
import org.junit.Test

import java.util.Arrays

/**
 * Created by Zahar on 16.05.16.
 */
class TextUtilsPreProcessTest {

	@Test
	fun testComplex() {
		val rawText = "qwer asdf qwer or qwer zxc"
		val dictionary = Arrays.asList("qwer or qwer", "qwer asdf")

		val strings = TextUtils.preProcessText(dictionary, rawText)
		Assert.assertEquals("|qwer asdf| |qwer or qwer| zxc", strings)
	}
}
