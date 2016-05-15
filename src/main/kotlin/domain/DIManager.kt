package domain

import datalayer.net.VkRest
import domain.providers.SchedulersDP
import presentationlayer.MainSchedulers

/**
 * Created by Zahar on 07.05.16.
 */
class DIManager {

	companion object {

		private val schedulers: Lazy<SchedulersDP> = lazy { MainSchedulers() }

		private val vkRest: Lazy<VkRest> = lazy { VkRest() }
		private val vkRestApi = lazy { vkRest.value.getRest() }

	}
}