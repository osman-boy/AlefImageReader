package kz.osman.alefimagereader.data.repository

import kz.osman.alefimagereader.data.network.ApiService
import kz.osman.alefimagereader.domain.repository.ImageRepository
import javax.inject.Inject

/**
 * Created by Osman Zhuzhoev on 3/9/2022.
 */
class ImageRepositoryImpl @Inject constructor(private val apiService: ApiService) : ImageRepository {

    override suspend fun getImageUrlList(): ArrayList<String> {
        return apiService.getImageList()
    }
}