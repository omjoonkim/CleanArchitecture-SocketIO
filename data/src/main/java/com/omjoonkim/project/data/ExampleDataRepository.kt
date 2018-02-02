package com.omjoonkim.project.data

import com.omjoonkim.project.data.mapper.ModelAMapper
import com.omjoonkim.project.data.mapper.ModelBMapper
import com.omjoonkim.project.data.repository.ExampleConnectable
import com.omjoonkim.project.domain.model.ExampleModels
import com.omjoonkim.project.domain.repository.ExampleRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class ExampleDataRepository @Inject constructor(
    override val connectable: ExampleConnectable,
    private val modelAMapper : ModelAMapper,
    private val modelBMapper: ModelBMapper
) : ExampleRepository {

    override fun getModelAStream(): Observable<ExampleModels.ModelA> = connectable.getModelAStream()
        .map { modelAMapper.mapFromEntity(it) }

    override fun getModelBStream(): Observable<ExampleModels.ModelB> = connectable.getModelBStream()
        .map { modelBMapper.mapFromEntity(it) }

    override fun requestModelA(): Completable = connectable.requestModelA()

    override fun requestModelB(): Completable = connectable.requestModelB()
}
