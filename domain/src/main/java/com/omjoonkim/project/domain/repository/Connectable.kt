package com.omjoonkim.project.domain.repository

interface Connectable {

    val isConnected: Boolean
    fun connect()
    fun disconnect()
}

