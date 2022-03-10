package kz.osman.alefimagereader.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.osman.alefimagereader.domain.usecase.GetImageUrlListUseCase
import javax.inject.Inject

/**
 * Created by Osman Zhuzhoev on 3/10/2022.
 */
class MainViewModelFactory @Inject constructor(val useCase: GetImageUrlListUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(useCase) as T
    }
}