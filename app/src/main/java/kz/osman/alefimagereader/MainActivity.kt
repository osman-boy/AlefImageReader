package kz.osman.alefimagereader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.osman.alefimagereader.data.network.ApiFactory
import kz.osman.alefimagereader.data.repository.ImageRepositoryImpl

/**
 * Created by Osman Zhuzhoev at 03.09.2022
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = ImageRepositoryImpl(ApiFactory.apiService)

        val dispather = CoroutineScope(Dispatchers.Default)
        dispather.launch {
            repository.getImageUrlList()
        }
    }
}