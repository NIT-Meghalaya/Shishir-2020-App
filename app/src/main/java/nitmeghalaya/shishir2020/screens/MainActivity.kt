package nitmeghalaya.shishir2020.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import nitmeghalaya.shishir2020.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.showBottomNav(bottomNavigationView)

        setSupportActionBar(toolbar)

        navController = findNavController(R.id.navHostFragment)
        bottomNavigationView.setupWithNavController(navController)

        //This prevents showing of up button on toolbar for fragments at top level
        val appBarConfiguration = AppBarConfiguration(bottomNavigationView.menu)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener(destinationChangedListener)

        mainViewModel.bottomNavigationVisibility.observe(this, Observer { navVisibility ->
            bottomNavigationView.visibility = navVisibility
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostFragment).navigateUp()
                || super.onSupportNavigateUp()
    }

    private val destinationChangedListener = NavController.OnDestinationChangedListener { _, destination, _ ->
        when(destination.id) {
            R.id.teamMembersFragment -> mainViewModel.hideBottomNav(bottomNavigationView)
            else -> mainViewModel.showBottomNav(bottomNavigationView)
        }
    }
}
