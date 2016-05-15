package domain

import datalayer.net.VkRest
import datalayer.providers.DictionariesDPImpl
import datalayer.providers.TextDPImpl
import domain.providers.SchedulersDP
import domain.providers.TextDP
import presentationlayer.MainSchedulers

/**
 * Created by Zahar on 07.05.16.
 */
class DIManager {

	companion object {

		private val schedulers: Lazy<SchedulersDP> = lazy { MainSchedulers() }

		private val vkRest: Lazy<VkRest> = lazy { VkRest() }
		private val vkRestApi = lazy { vkRest.value.getRest() }
		private val textDP = lazy { TextDPImpl() }
		private val dictionariesDP = lazy { DictionariesDPImpl() }


		fun getTextDP(): TextDP {
			return textDP.value
		}
		fun getDictionariesDP(): DictionariesDPImpl {
			return dictionariesDP.value
		}
	}
}