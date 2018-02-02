package com.omjoonkim.project.remote.mapper

import com.omjoonkim.project.data.model.ModelAEntity
import com.omjoonkim.project.remote.model.ModelARemoteModel
import javax.inject.Inject

open class ModelAEntityMapper @Inject constructor(): EntityMapper<ModelARemoteModel, ModelAEntity> {

    override fun mapFromRemote(model: ModelARemoteModel): ModelAEntity {
        return ModelAEntity(model.a)
    }
}
