package com.omjoonkim.project.cleanarchitectureSocket.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.omjoonkim.project.cleanarchitectureSocket.injection.component.MainActivitySubComponent
import com.omjoonkim.project.cleanarchitectureSocket.injection.scopes.PerActivity
import com.omjoonkim.project.cleanarchitectureSocket.ui.MainActivity

@Module(subcomponents = [(MainActivitySubComponent::class)])
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

}
