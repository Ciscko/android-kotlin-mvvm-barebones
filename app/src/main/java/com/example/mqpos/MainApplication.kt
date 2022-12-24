package com.example.mqpos

import android.app.Application
import com.example.qkpos.model.data.db.MainDataBase
import com.example.qkpos.model.repositories.MainRepositoryImplementation
import com.example.qkpos.view_model.viewmodels.MainViewModel
import com.example.qkpos.view_model.viewmodels.MainViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MainApplication : Application(), KodeinAware {
    override val kodein: Kodein by Kodein.lazy {
        import(androidXModule(this@MainApplication))
        bind<MainDataBase>() with singleton { MainDataBase.getDatabaseInstance(context = instance())}
        bind<MainRepositoryImplementation>() with singleton { MainRepositoryImplementation(db = instance()) }
        bind<MainViewModelFactory>() with provider { MainViewModelFactory(mainRepositoryImplementation = instance()) }
    }
}