package domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zahar on 16.05.16.
 */
public class TextUtilsPostProcessTest {

	@Test
	public void testComplex() {
		String rawText = "qwer asdf qwer or qwer zxc";
		List<String> dictionary = Arrays.asList("qwer or qwer", "qwer asdf");

		String strings = TextUtils.Companion.preProcessText(dictionary, rawText);
		Assert.assertEquals("|qwer asdf| |qwer or qwer| zxc", strings);
	}
}
