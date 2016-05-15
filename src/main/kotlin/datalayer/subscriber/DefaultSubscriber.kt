package datalayer.subscriber


/**
 * Created by root on 15.03.16.
 */
open class DefaultSubscriber<T> : rx.Subscriber<T>() {

	override fun onNext(next: T) {

	}

	override fun onError(e: Throwable) {
		println(e)
	}

	override fun onCompleted() {

	}
}
