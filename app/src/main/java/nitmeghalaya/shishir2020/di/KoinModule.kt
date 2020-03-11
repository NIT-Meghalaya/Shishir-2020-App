package nitmeghalaya.shishir2020.di

import nitmeghalaya.shishir2020.datasource.FacebookPageFeedDataSourceFactory
import nitmeghalaya.shishir2020.repository.FacebookPageRepository
import nitmeghalaya.shishir2020.repository.FirestoreRepository
import nitmeghalaya.shishir2020.screens.eventslist.EventsListViewModel
import nitmeghalaya.shishir2020.screens.facebookpagefeed.FacebookPageFeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Devansh on 7/3/20
 */

val firestoreRepositoryModule = module {
    single { FirestoreRepository() }
}

val facebookPageRepositoryModule = module {
    single { FacebookPageRepository() }
}

val facebookPageFeedDataSourceFactory = module {
    single { FacebookPageFeedDataSourceFactory() }
}

val appModule = module {
    viewModel { FacebookPageFeedViewModel(get()) }
    viewModel { EventsListViewModel(get()) }
}