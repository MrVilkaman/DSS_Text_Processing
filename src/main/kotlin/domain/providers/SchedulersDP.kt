package domain.providers

import rx.Scheduler

/**
 * Created by Zahar on 22.01.2016.
 */
interface SchedulersDP {

	fun mainThread(): Scheduler

	fun io(): Scheduler

	fun computation(): Scheduler

	fun immediate(): Scheduler
}
