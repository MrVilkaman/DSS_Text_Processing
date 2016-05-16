package datalayer.providers

import domain.providers.DictionariesDP
import java.util.*

/**
 * Created by Zahar on 15.05.16.
 */
class DictionariesDPImpl : DictionariesDP {

	override fun getDictionaryAbbreviations(): List<String> {
		return Arrays.asList(
			"R.",
			"A.",
			"T."
		)

	}

	override fun getDictionaryStopWords(): List<String> {
		return Arrays.asList(
			"и",
			"-",
			"—",
			"еще",
			"него",
			"сказать",
			"а",
			"ж",
			"нее",
			"со",
			"без",
			"же",
			"ней",
			"совсем",
			"более",
			"жизнь",
			"нельзя",
			"так",
			"больше",
			"за",
			"нет",
			"такой",
			"будет",
			"зачем",
			"ни",
			"там",
			"будто",
			"здесь",
			"нибудь",
			"тебя",
			"бы",
			"никогда",
			"тем",
			"был",
			"из",
			"ним",
			"теперь",
			"была",
			"из-за",
			"них",
			"то",
			"были",
			"или",
			"ничего",
			"тогда",
			"было",
			"им",
			"но",
			"того",
			"быть",
			"иногда",
			"ну",
			"тоже",
			"в",
			"их",
			"о",
			"только",
			"вам",
			"к",
			"об",
			"том",
			"вас",
			"кажется",
			"один",
			"тот",
			"вдруг",
			"как",
			"он",
			"три",
			"ведь",
			"какая",
			"она",
			"тут",
			"во",
			"какой",
			"они",
			"ты",
			"вот",
			"когда",
			"опять",
			"у",
			"впрочем",
			"конечно",
			"от",
			"уж",
			"все",
			"которого",
			"перед",
			"уже",
			"всегда",
			"которые",
			"по",
			"хорошо",
			"всего",
			"кто",
			"под",
			"хоть",
			"всех",
			"куда",
			"после",
			"чего",
			"всю",
			"ли",
			"потом",
			"человек",
			"вы",
			"лучше",
			"потому",
			"чем",
			"г",
			"между",
			"почти",
			"через",
			"где",
			"меня",
			"при",
			"что",
			"говорил",
			"мне",
			"про",
			"чтоб",
			"да",
			"много",
			"раз",
			"чтобы",
			"даже",
			"может",
			"разве",
			"чуть",
			"два",
			"можно",
			"с",
			"эти",
			"для",
			"мой",
			"сам",
			"этого",
			"до",
			"моя",
			"свое",
			"этой",
			"это",
			"другой",
			"мы",
			"свою",
			"этом",
			"его",
			"на",
			"себе",
			"этот",
			"ее",
			"над",
			"себя",
			"эту",
			"ей",
			"надо",
			"сегодня",
			"я",
			"ему",
			"наконец",
			"сейчас",
			"если",
			"нас",
			"сказал",
			"есть",
			"не",
			"сказала"
			)
	}
}