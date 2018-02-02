package com.omjoonkim.project.remote.mapper

import com.omjoonkim.project.data.model.ModelBEntity
import com.omjoonkim.project.remote.model.ModelBRemoteModel
import javax.inject.Inject

open class ModelBEntityMapper @Inject constructor(): EntityMapper<ModelBRemoteModel, ModelBEntity> {

    override fun mapFromRemote(model: ModelBRemoteModel): ModelBEntity {
        return ModelBEntity(model.b)
    }
}
