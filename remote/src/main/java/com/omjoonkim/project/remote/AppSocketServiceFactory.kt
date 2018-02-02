package com.omjoonkim.project.remote

import io.socket.client.Manager
import java.net.URI

object AppSocketServiceFactory {

    private val baseSocketUrl: String = "https://localhost"

    private enum class SocketNameSpace(val value: String) {
        CARD("/cards")
    }

    private val socketManager: Manager by lazy {
        Manager(URI(baseSocketUrl))
    }

    fun exampleSocket() = AppSocket(socketManager.socket(SocketNameSpace.CARD.value))
}
