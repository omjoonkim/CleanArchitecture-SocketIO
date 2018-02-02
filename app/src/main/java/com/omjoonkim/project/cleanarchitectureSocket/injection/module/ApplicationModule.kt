package com.omjoonkim.project.cleanarchitectureSocket.injection.module

import android.app.Application
import android.content.Context
import com.omjoonkim.project.cleanarchitectureSocket.UiThread
import com.omjoonkim.project.cleanarchitectureSocket.injection.scopes.PerApplication
import com.omjoonkim.project.data.ExampleDataRepository
import com.omjoonkim.project.data.executor.JobExecutor
import com.omjoonkim.project.data.repository.ExampleConnectable
import com.omjoonkim.project.domain.executor.PostExecutionThread
import com.omjoonkim.project.domain.executor.ThreadExecutor
import com.omjoonkim.project.domain.repository.ExampleRepository
import com.omjoonkim.project.remote.AppSocket
import com.omjoonkim.project.remote.ExampleConnectableImpl
import com.omjoonkim.project.remote.AppSocketServiceFactory
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context = application

    @Provides
    @PerApplication
    internal fun provideExampleSocket(): AppSocket = AppSocketServiceFactory.exampleSocket()

    @Provides
    @PerApplication
    internal fun provideExampleConnectable(exampleSocket: AppSocket): ExampleConnectable =
        ExampleConnectableImpl(exampleSocket)

    @Provides
    @PerApplication
    internal fun provideExampleRepository(connectable: ExampleConnectable): ExampleRepository =
        ExampleDataRepository(connectable)

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread = uiThread
}
