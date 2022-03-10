package kz.osman.alefimagereader.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kz.osman.alefimagereader.domain.usecase.GetImageUrlListUseCase
import javax.inject.Inject

/**
 * Created by Osman Zhuzhoev on 3/9/2022.
 */
class MainViewModel @Inject constructor(private val getImageUrlListUseCase: GetImageUrlListUseCase) : ViewModel() {


    val imageUrlList: LiveData<ArrayList<String>> = liveData(viewModelScope.coroutineContext) {
        emit(getImageUrlListUseCase.invoke())
    }


}