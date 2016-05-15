package presentationlayer

import domain.providers.SchedulersDP
import rx.Scheduler
import rx.schedulers.Schedulers

/**
 * Created by Zahar on 07.05.16.
 */
class MainSchedulers :SchedulersDP{
	override fun mainThread(): Scheduler = Schedulers.immediate()

	override fun io(): Scheduler = Schedulers.immediate()

	override fun computation(): Scheduler = Schedulers.immediate()

	override fun immediate(): Scheduler = Schedulers.immediate()
}