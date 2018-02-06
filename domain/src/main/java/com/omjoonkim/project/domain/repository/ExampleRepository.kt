package com.omjoonkim.project.domain.repository

import com.omjoonkim.project.domain.model.ExampleModels
import io.reactivex.Completable
import io.reactivex.Observable

interface ExampleRepository {

    val connectable : Connectable

    fun getModelAStream(): Observable<ExampleModels.ModelA>
    fun getModelBStream(): Observable<ExampleModels.ModelB>
    fun requestModelA(): Completable
    fun requestModelB(): Completable
}

