package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import domain.TextUtils;

/**
 * Created by Zahar on 16.05.16.
 */
public class TextUtilsWordSplitTest {

	@Test
	public void testComplex() {
		String rawText = "qwer asdf |qwer or qwer| zxc";
		//
		ArrayList<String> strings = TextUtils.Companion.splitByWords(Collections.emptyList(), rawText);
		Assertions.assertThat(strings)
			.hasSize(6)
			.contains("qwer", "asdf","|qwer","or","qwer|", "zxc");
	}

	@Test
	public void testRemoveStopWords() {
		String rawText = "qwer asdf qwer or qwer zxc";
		List<String> dictionaryStopWords = Arrays.asList("or","zxc");
		//
		ArrayList<String> strings = TextUtils.Companion.splitByWords(dictionaryStopWords, rawText);
		Assertions.assertThat(strings)
			.hasSize(4)
			.contains("qwer", "asdf","qwer","qwer");
	}

	@Test
	public void testSimpleSplit() {
		String rawText = "qwer asdf qwer qwer zxc";
		//
		ArrayList<String> strings = TextUtils.Companion.splitByWords(Collections.emptyList(), rawText);
		Assertions.assertThat(strings)
			.hasSize(5)
			.contains("qwer", "asdf","qwer", "qwer", "zxc");
	}

	@Test
	public void testSimpleSplit2() {
		String rawText = "qwer! asdf? qwer. qwer) (zxc";
		//
		ArrayList<String> strings = TextUtils.Companion.splitByWords(Collections.emptyList(), rawText);
		Assertions.assertThat(strings)
			.hasSize(5)
			.contains("qwer", "asdf","qwer", "qwer", "zxc");
	}
}
