package com.omjoonkim.project.cleanarchitectureSocket.injection.module

import com.omjoonkim.project.cleanarchitectureSocket.injection.scopes.PerActivity
import com.omjoonkim.project.cleanarchitectureSocket.ui.MainActivity
import com.omjoonkim.project.domain.interactor.ExampleConnectableUseCase
import com.omjoonkim.project.presentation.main.MainContract
import com.omjoonkim.project.presentation.main.MainPresenter
import dagger.Module
import dagger.Provides


@Module
open class MainActivityModule {

    @PerActivity
    @Provides
    internal fun provideMainView(mainActivity: MainActivity): MainContract.View = mainActivity

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(
        mainView: MainContract.View,
        exampleConnectableUseCase: ExampleConnectableUseCase
    ): MainContract.Presenter = MainPresenter(mainView, exampleConnectableUseCase)

}
