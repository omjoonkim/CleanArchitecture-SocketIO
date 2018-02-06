package com.omjoonkim.project.presentation.main

import com.omjoonkim.project.domain.interactor.ExampleCnnectableUseCase
import com.omjoonkim.project.domain.model.ExampleModels
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val mainView: MainContract.View,
    private val exampleConnectable: ExampleCnnectableUseCase
) : MainContract.Presenter {

    init {
        mainView.setPresenter(this)
    }

    override fun onStart() {
        exampleConnectable.connect(javaClass.name, object : DisposableSubscriber<ExampleModels>() {
            override fun onNext(t: ExampleModels) {
                when (t) {
                    is ExampleModels.ModelA -> {
                        mainView.showAData(listOf(t))
                    }
                    is ExampleModels.ModelB -> {
                        mainView.showBData(listOf(t))
                    }
                }
            }

            override fun onComplete() {
                /* explicitly empty */
            }

            override fun onError(t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    override fun onStop() {
        exampleConnectable.dispose(javaClass.name)
    }

    override fun onClickAButton() {
        exampleConnectable.requestModelA()
            .subscribe({
                /* explicitly empty */
            }, {
                it.printStackTrace()
            })
    }

    override fun onClickBButton() {
        exampleConnectable.requestModelB()
            .subscribe({
                /* explicitly empty */
            }, {
                it.printStackTrace()
            })
    }
}
