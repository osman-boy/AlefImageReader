package kz.osman.alefimagereader.data.network

import retrofit2.http.GET

/**
 * Created by Osman Zhuzhoev on 3/9/2022.
 */

interface ApiService {

    @GET(".")
    suspend fun getImageList(): ArrayList<String>

}