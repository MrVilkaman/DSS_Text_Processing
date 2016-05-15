package domain.usecase.core

import rx.Observable
import rx.Scheduler
import rx.Subscriber
import rx.subscriptions.Subscriptions

/**
 * Created by root on 15.03.16.
 */
abstract class UseCase<T>(private val subscribeOn: Scheduler,
                          private val observeOn: Scheduler) {

	private var subscription = Subscriptions.empty()

	protected abstract fun buildUseCaseObservable(): Observable<T>

	@SuppressWarnings("unchecked")
	fun execute(UseCaseSubscriber: Subscriber<T>) {
		this.subscription =
			this.buildUseCaseObservable()
			.subscribeOn(subscribeOn)
			.observeOn(observeOn)
			.subscribe(UseCaseSubscriber)
	}

	fun unsubscribe() {
		if (!subscription.isUnsubscribed) {
			subscription.unsubscribe()
		}
	}

}
