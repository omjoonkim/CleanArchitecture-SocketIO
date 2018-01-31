package com.omjoonkim.project.cleanarchitectureSocket.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.omjoonkim.project.cleanarchitectureSocket.App
import com.omjoonkim.project.cleanarchitectureSocket.injection.module.ActivityBindingModule
import com.omjoonkim.project.cleanarchitectureSocket.injection.module.ApplicationModule
import com.omjoonkim.project.cleanarchitectureSocket.injection.scopes.PerApplication

@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: App)

}
