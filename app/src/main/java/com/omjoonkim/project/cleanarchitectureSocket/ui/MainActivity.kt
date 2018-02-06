package com.omjoonkim.project.cleanarchitectureSocket.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.omjoonkim.project.cleanarchitectureSocket.R
import com.omjoonkim.project.domain.model.ExampleModels
import com.omjoonkim.project.presentation.main.MainContract
import dagger.android.AndroidInjection
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

        mainPresenter.onStart()

        button_requestA.setOnClickListener {
            mainPresenter.onClickAButton()
        }

        button_requestB.setOnClickListener {
            mainPresenter.onClickBButton()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.onStop()
    }
}
