package com.omjoonkim.project.data.mapper

import com.omjoonkim.project.data.model.ModelAEntity
import com.omjoonkim.project.domain.model.ExampleModels
import org.buffer.android.boilerplate.data.mapper.Mapper
import javax.inject.Inject


open class ModelAMapper @Inject constructor() : Mapper<ModelAEntity, ExampleModels.ModelA> {

    override fun mapFromEntity(type: ModelAEntity): ExampleModels.ModelA {
        return ExampleModels.ModelA(type.a)
    }

    override fun mapToEntity(type: ExampleModels.ModelA): ModelAEntity {
        return ModelAEntity(type.a)
    }


}
