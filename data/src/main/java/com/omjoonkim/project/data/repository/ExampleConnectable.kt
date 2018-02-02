package com.omjoonkim.project.data.repository

import com.omjoonkim.project.data.model.ModelAEntity
import com.omjoonkim.project.data.model.ModelBEntity
import com.omjoonkim.project.domain.repository.Connectable
import io.reactivex.Completable
import io.reactivex.Observable

interface ExampleConnectable : Connectable{
    fun getModelAStream(): Observable<ModelAEntity>
    fun getModelBStream(): Observable<ModelBEntity>
    fun requestModelA(): Completable
    fun requestModelB(): Completable
}
