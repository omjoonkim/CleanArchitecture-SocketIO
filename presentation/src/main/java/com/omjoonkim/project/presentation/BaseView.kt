package com.omjoonkim.project.presentation

interface BaseView<in T : BasePresenter> {

    fun setPresenter(presenter: T)
}
