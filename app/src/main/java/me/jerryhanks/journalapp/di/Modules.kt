package me.jerryhanks.journalapp.di

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import me.jerryhanks.journalapp.AppExecutors
import me.jerryhanks.journalapp.R
import me.jerryhanks.journalapp.data.DataSource
import me.jerryhanks.journalapp.data.Repository
import me.jerryhanks.journalapp.data.db.JournalDb
import me.jerryhanks.journalapp.ui.createorupdate.CreateOrUpdateViewModel
import me.jerryhanks.journalapp.ui.entries.EntriesViewModel
import me.jerryhanks.journalapp.ui.utils.NavigationUtils
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext


/**
 * @author Po10cio on 26/06/2018
 * @mail jerryhanksokafor@gmail.com
 * @for JournalApp
 */


/**
 * App Module definitions
 * */
val appModule: Module = applicationContext {
    bean { NavigationUtils }
    bean {
        GoogleSignIn.getClient(androidApplication(),
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(androidApplication().getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build())
    }
    bean { AppExecutors() }
    bean { JournalDb.create(androidApplication(), false) }
    bean { Repository(get(), get()) as DataSource }

    //viewModels
    viewModel { CreateOrUpdateViewModel(get()) }
    viewModel { EntriesViewModel(get()) }
}

/**
 * In - Memory Room database definition for testing
 * */
val roomTestModule: Module = applicationContext {
    bean { JournalDb.create(androidApplication(), true) }
}