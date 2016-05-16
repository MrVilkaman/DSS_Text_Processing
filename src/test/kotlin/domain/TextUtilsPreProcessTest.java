package domain;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zahar on 16.05.16.
 */
public class TextUtilsPreProcessTest {

	@Test
	public void testComplex() {
		List<String> words = Arrays.asList("qwer", "asdf","|qwer","or","qwer|", "zxc");

		List<String> wordsqwer = TextUtils.Companion.postProcessText(words);
		Assertions.assertThat(wordsqwer)
			.hasSize(4)
			.contains("qwer", "asdf","qwer or qwer","zxc");
	}
}
