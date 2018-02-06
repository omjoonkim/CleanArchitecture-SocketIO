package com.omjoonkim.project.domain.interactor

import com.omjoonkim.project.domain.executor.PostExecutionThread
import com.omjoonkim.project.domain.executor.ThreadExecutor
import com.omjoonkim.project.domain.model.ExampleModels
import com.omjoonkim.project.domain.repository.ExampleRepository
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ExampleCnnectableUseCase @Inject constructor(
    private val repository: ExampleRepository,
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : ConnectableUseCase<ExampleModels>(
    repository.connectable,
    postExecutionThread,
    threadExecutor
) {

    init {
        repository.getModelAStream().subscribe {
            output.accept(it)
        }
        repository.getModelBStream().subscribe {
            output.accept(it)
        }
    }

    fun requestModelA() = repository
        .requestModelA()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)

    fun requestModelB() = repository
        .requestModelB()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)
}
