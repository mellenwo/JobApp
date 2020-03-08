package com.mellenwood.jobsapp

import android.app.Application
import com.mellenwood.jobsapp.di.AppModule.Companion.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class JobApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@JobApplication)
            modules(appModule)
        }
    }

}