package com.omjoonkim.project.data

import com.omjoonkim.project.data.repository.ExampleConnectable
import com.omjoonkim.project.domain.model.ExampleModels
import com.omjoonkim.project.domain.repository.ExampleRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class ExampleDataRepository @Inject constructor(override val connectable: ExampleConnectable) : ExampleRepository {

    override fun getModelAStream(): Observable<ExampleModels.ModelA> = connectable.getModelAStream()

    override fun getModelBStream(): Observable<ExampleModels.ModelB> = connectable.getModelBStream()

    override fun requestModelA(): Completable = connectable.requestModelA()

    override fun requestModelB(): Completable = connectable.requestModelB()
}
