package com.omjoonkim.project.presentation.main

import com.omjoonkim.project.domain.model.ExampleModels
import com.omjoonkim.project.presentation.BasePresenter
import com.omjoonkim.project.presentation.BaseView

interface MainContract {

    interface View : BaseView<Presenter> {

        fun showAData(data: List<ExampleModels.ModelA>)
        fun showBData(data: List<ExampleModels.ModelB>)

    }

    interface Presenter : BasePresenter {

        fun onClickAButton()
        fun onClickBButton()
    }
}
