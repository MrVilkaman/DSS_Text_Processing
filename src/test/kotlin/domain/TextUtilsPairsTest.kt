package domain

import org.assertj.core.api.Assertions
import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by Zahar on 20.05.16.
 */
class TextUtilsPairsTest {

	@Test
	public  fun testGroup() {
		val list = ArrayList<Pair<String, String>>()
		list.add(Pair("A", "B"))
		list.add(Pair("B", "A"))
		list.add(Pair("D", "A"))

		val groupBy = TextUtils.groupPairs(list)

		//
		Assert.assertEquals(2,groupBy.size)
		val get = groupBy.get(Pair("A", "B"))
		Assertions.assertThat(get).isNotNull()
		Assert.assertEquals(2,get?.size)

		val get2 = groupBy.get(Pair("A","D"))
		Assertions.assertThat(get2).isNotNull()
		Assert.assertEquals(1,get2?.size)


		for (w in groupBy) {
			println("${w.key} ${w.value.size}")
		}
	}
}