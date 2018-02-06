package com.omjoonkim.project.remote

import com.omjoonkim.project.data.model.ModelAEntity
import com.omjoonkim.project.data.model.ModelBEntity
import com.omjoonkim.project.data.repository.ExampleConnectable
import com.omjoonkim.project.remote.mapper.ModelAEntityMapper
import com.omjoonkim.project.remote.mapper.ModelBEntityMapper
import com.omjoonkim.project.remote.model.ModelARemoteModel
import com.omjoonkim.project.remote.model.ModelBRemoteModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.socket.emitter.Emitter
import javax.inject.Inject

class ExampleConnectableImpl @Inject constructor(
    private val appSocket: AppSocket,
    private val aMapper: ModelAEntityMapper,
    private val bMapper: ModelBEntityMapper
) : ExampleConnectable {
    override val isConnected: Boolean get() = appSocket.isConnected

    private val modelA by lazy {
        Observable.create<ModelARemoteModel> { emitter ->
            appSocket.on("modelA", Emitter.Listener {
                emitter.onNext(ModelARemoteModel(""))
            })
        }.share()
    }

    private val modelB by lazy {
        Observable.create<ModelBRemoteModel> { emitter ->
            appSocket.on("modelB", Emitter.Listener {
                emitter.onNext(ModelBRemoteModel(""))
            })
        }.share()
    }

    override fun connect() = appSocket.connect()

    override fun disconnect() = appSocket.disconnect()

    override fun getModelAStream(): Observable<ModelAEntity> = modelA.map { aMapper.mapFromRemote(it) }

    override fun getModelBStream(): Observable<ModelBEntity> = modelB.map { bMapper.mapFromRemote(it) }

    override fun requestModelA(): Completable = appSocket.request("modelA", Any())

    override fun requestModelB(): Completable = appSocket.request("modelB", Any())
}
