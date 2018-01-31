
package com.omjoonkim.project.cleanarchitectureSocket.injection.component

import com.omjoonkim.project.cleanarchitectureSocket.ui.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}
