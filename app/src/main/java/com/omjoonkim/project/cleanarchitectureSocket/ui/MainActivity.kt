package com.omjoonkim.project.cleanarchitectureSocket.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.omjoonkim.project.cleanarchitectureSocket.R
import com.omjoonkim.project.domain.model.ExampleModels
import com.omjoonkim.project.presentation.main.MainContract
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject lateinit var mainPresenter: MainContract.Presenter

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.mainPresenter = presenter
    }

    override fun showAData(data: List<ExampleModels.ModelA>) {
    }

    override fun showBData(data: List<ExampleModels.ModelB>) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        button_requestA.setOnClickListener {
            mainPresenter.onClickAButton()
        }

        button_requestB.setOnClickListener {
            mainPresenter.onClickBButton()
        }

    }

}
