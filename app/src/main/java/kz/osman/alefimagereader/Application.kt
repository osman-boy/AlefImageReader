package kz.osman.alefimagereader

import android.app.Application
import kz.osman.alefimagereader.di.AppComponent
import kz.osman.alefimagereader.di.DaggerAppComponent

/**
 * Created by Osman Zhuzhoev on 3/10/2022.
 */
class Application : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.create()
    }

}