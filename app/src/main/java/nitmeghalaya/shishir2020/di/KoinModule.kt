package nitmeghalaya.shishir2020.di

import nitmeghalaya.shishir2020.repository.FirestoreRepository
import nitmeghalaya.shishir2020.screens.eventslist.EventsListViewModel
import nitmeghalaya.shishir2020.screens.shishirpagefeed.ShishirPageFeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Devansh on 7/3/20
 */

val firestoreRepositoryModule = module {
    single { FirestoreRepository() }
}

val appModule = module {
    viewModel { ShishirPageFeedViewModel(get()) }
    viewModel { EventsListViewModel(get()) }
}