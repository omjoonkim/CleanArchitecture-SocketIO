package com.omjoonkim.project.domain.repository

import io.reactivex.Completable

interface Connectable {

    val isConnected: Boolean
    fun connect()
    fun disconnect()
}

