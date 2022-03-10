package kz.osman.alefimagereader.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kz.osman.alefimagereader.data.network.ApiFactory
import kz.osman.alefimagereader.data.repository.ImageRepositoryImpl
import kz.osman.alefimagereader.domain.repository.ImageRepository

/**
 * Created by Osman Zhuzhoev on 3/10/2022.
 */
@Module
interface DataModule {


    @Binds
    fun bindRepository(impl: ImageRepositoryImpl): ImageRepository

    companion object {
        @Provides
        fun provideApiService() = ApiFactory.apiService

    }
}