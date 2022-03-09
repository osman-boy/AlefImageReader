package kz.osman.alefimagereader.domain.usecase

import kz.osman.alefimagereader.domain.repository.ImageRepository

/**
 * Created by Osman Zhuzhoev on 3/9/2022.
 */
class GetImageUrlListUseCase(private val repository: ImageRepository) {

    suspend operator fun invoke(): ArrayList<String> {
        return repository.getImageUrlList()
    }

}