package kz.osman.alefimagereader.di

import dagger.Component
import kz.osman.alefimagereader.presentation.ui.ImageListFragment
import kz.osman.alefimagereader.presentation.viewmodels.MainViewModelFactory

/**
 * Created by Osman Zhuzhoev on 3/10/2022.
 */
@Component(modules = [DataModule::class])
interface AppComponent {

    fun viewModelFactory(): MainViewModelFactory
}