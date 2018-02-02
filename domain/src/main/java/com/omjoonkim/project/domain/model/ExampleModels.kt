package com.omjoonkim.project.domain.model

sealed class ExampleModels {
    data class ModelA(
        val a: String
    ) : ExampleModels()

    data class ModelB(
        val b: String
    ) : ExampleModels()
}
