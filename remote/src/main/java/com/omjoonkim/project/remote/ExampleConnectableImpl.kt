package com.omjoonkim.project.remote

import com.omjoonkim.project.data.repository.ExampleConnectable
import com.omjoonkim.project.domain.model.ExampleModels
import io.reactivex.Completable
import io.reactivex.Observable
import io.socket.emitter.Emitter
import javax.inject.Inject

class ExampleConnectableImpl @Inject constructor(private val appSocket: AppSocket) : ExampleConnectable {
    override val isConnected: Boolean = appSocket.isConnected

    private val modelA by lazy {
        Observable.create<ExampleModels.ModelA> { emitter ->
            appSocket.on("modelA", Emitter.Listener {
                emitter.onNext(ExampleModels.ModelA(""))
            })
        }.share()
    }

    private val modelB by lazy {
        Observable.create<ExampleModels.ModelB> { emitter ->
            appSocket.on("modelB", Emitter.Listener {
                emitter.onNext(ExampleModels.ModelB(""))
            })
        }.share()
    }

    override fun connect() = appSocket.connect()

    override fun disconnect() = appSocket.disconnect()

    override fun getModelAStream(): Observable<ExampleModels.ModelA> = modelA

    override fun getModelBStream(): Observable<ExampleModels.ModelB> = modelB

    override fun requestModelA(): Completable = appSocket.request("modelA", Any())

    override fun requestModelB(): Completable = appSocket.request("modelB", Any())
}
