package com.omjoonkim.project.remote

import io.reactivex.Completable
import io.socket.client.Socket
import io.socket.emitter.Emitter

class AppSocket(private val socket: Socket) {

    private val listeners: MutableList<CommonListener> = mutableListOf()

    val isConnected: Boolean get() = socket.connected()

    init {
        socket.on(Socket.EVENT_CONNECT, {
            listeners.forEach {
                it.onConnect(socket)
            }
        })
    }

    fun connect() {
        socket.open()
    }

    fun disconnect() {
        socket.close()
    }

    fun request(name: String, any: Any): Completable =
        if (isConnected)
            Completable.fromCallable {
                socket.emit(name, any)
            }
        else
            Completable.error(SocketNotConnectedException())

    fun on(name: String, listener: Emitter.Listener) {
        socket.on(name, listener)
    }

    fun addListener(listener: CommonListener) {
        listeners.add(listener)
    }

    fun removeListener(listener: CommonListener) {
        listeners.iterator().run {
            while (hasNext())
                if (next() == listener)
                    remove()
        }
    }

    interface CommonListener {
        fun onConnect(socket: Socket)
    }
}


class SocketNotConnectedException : Throwable()
