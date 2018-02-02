package com.omjoonkim.project.data.mapper

import com.omjoonkim.project.data.model.ModelBEntity
import com.omjoonkim.project.domain.model.ExampleModels
import org.buffer.android.boilerplate.data.mapper.Mapper
import javax.inject.Inject


open class ModelBMapper @Inject constructor() : Mapper<ModelBEntity, ExampleModels.ModelB> {

    override fun mapFromEntity(type: ModelBEntity): ExampleModels.ModelB {
        return ExampleModels.ModelB(type.b)
    }

    override fun mapToEntity(type: ExampleModels.ModelB): ModelBEntity {
        return ModelBEntity(type.b)
    }
}
