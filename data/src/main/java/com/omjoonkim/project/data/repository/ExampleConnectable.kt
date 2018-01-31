package com.omjoonkim.project.data.repository

import com.omjoonkim.project.domain.model.ExampleModels
import com.omjoonkim.project.domain.repository.Connectable
import io.reactivex.Completable
import io.reactivex.Observable

interface ExampleConnectable : Connectable{
    fun getModelAStream(): Observable<ExampleModels.ModelA>
    fun getModelBStream(): Observable<ExampleModels.ModelB>
    fun requestModelA(): Completable
    fun requestModelB(): Completable
}
