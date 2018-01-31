package com.omjoonkim.project.domain.interactor

import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import com.omjoonkim.project.domain.executor.PostExecutionThread
import com.omjoonkim.project.domain.executor.ThreadExecutor
import com.omjoonkim.project.domain.repository.Connectable
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

abstract class ConnectableUseCase<OUTPUT>(
    private val connectable: Connectable,
    private val postExecutionThread: PostExecutionThread,
    private val threadExecutor: ThreadExecutor
) {
    protected val output: Relay<OUTPUT> by lazy { PublishRelay.create<OUTPUT>().toSerialized() }

    protected open fun buildOutput(): Observable<OUTPUT> = output

    private val disposeables by lazy { hashMapOf<String, DisposableSubscriber<OUTPUT>>() }

    fun connect(from: String, observer: DisposableSubscriber<OUTPUT>) {
        disposeables[from]?.dispose()
        if (connectable.isConnected.not())
            connectable.connect()
        disposeables.put(
            from,
            buildOutput()
                .toFlowable(BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribeWith(observer)
        )
    }

    fun dispose(from: String) {
        disposeables[from]?.dispose()
        if (disposeables.isEmpty())
            connectable.disconnect()
    }
}

