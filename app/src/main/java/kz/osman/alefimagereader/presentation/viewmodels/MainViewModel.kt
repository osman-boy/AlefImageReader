package kz.osman.alefimagereader.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kz.osman.alefimagereader.data.network.ApiFactory
import kz.osman.alefimagereader.data.repository.ImageRepositoryImpl
import kz.osman.alefimagereader.domain.repository.ImageRepository
import kz.osman.alefimagereader.domain.usecase.GetImageUrlListUseCase

/**
 * Created by Osman Zhuzhoev on 3/9/2022.
 */
class MainViewModel : ViewModel() {

    private val repository: ImageRepository = ImageRepositoryImpl(ApiFactory.apiService)
    private val getImageUrlListUseCase = GetImageUrlListUseCase(repository)


    val imageUrlList: LiveData<ArrayList<String>> = liveData(viewModelScope.coroutineContext) {
        emit(getImageUrlListUseCase.invoke())
    }


}