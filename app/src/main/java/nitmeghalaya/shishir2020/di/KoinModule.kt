package nitmeghalaya.shishir2020.di

import nitmeghalaya.shishir2020.datasource.FacebookPageFeedDataSourceFactory
import nitmeghalaya.shishir2020.repository.FacebookPageRepository
import nitmeghalaya.shishir2020.repository.FirestoreRepository
import nitmeghalaya.shishir2020.repository.SharedPrefsRepository
import nitmeghalaya.shishir2020.screens.MainViewModel
import nitmeghalaya.shishir2020.screens.eventdescription.team.EventDetailTeamViewModel
import nitmeghalaya.shishir2020.screens.eventslist.EventsListViewModel
import nitmeghalaya.shishir2020.screens.eventsschedule.EventsScheduleViewModel
import nitmeghalaya.shishir2020.screens.facebookpagefeed.FacebookPageFeedViewModel
import nitmeghalaya.shishir2020.screens.introslider.IntroSliderViewModel
import nitmeghalaya.shishir2020.screens.splash.SplashScreenViewModel
import nitmeghalaya.shishir2020.screens.sponsors.SponsorViewModel
import nitmeghalaya.shishir2020.screens.teammembers.TeamMembersViewModel
import nitmeghalaya.shishir2020.screens.teams.TeamListViewModel
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

val sharedPrefRepository = module {
    single { SharedPrefsRepository(get()) }
}

val facebookPageFeedDataSourceFactory = module {
    single { FacebookPageFeedDataSourceFactory() }
}

val appModule = module {
    viewModel { FacebookPageFeedViewModel(get()) }
    viewModel { EventsListViewModel(get()) }
    viewModel { EventsScheduleViewModel() }
    viewModel { EventDetailTeamViewModel(get()) }
    viewModel { SponsorViewModel(get()) }
    viewModel { TeamListViewModel(get()) }
    viewModel { TeamMembersViewModel() }
    viewModel { MainViewModel(get()) }
    viewModel { SplashScreenViewModel(get()) }
    viewModel { IntroSliderViewModel(get()) }
}