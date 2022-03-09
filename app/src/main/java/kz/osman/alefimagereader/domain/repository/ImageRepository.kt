package kz.osman.alefimagereader.domain.repository

/**
 * Created by Osman Zhuzhoev on 3/9/2022.
 */
interface ImageRepository {

    suspend fun getImageUrlList(): ArrayList<String>
}