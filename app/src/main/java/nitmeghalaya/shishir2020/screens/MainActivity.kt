package nitmeghalaya.shishir2020.screens

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
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

        bottomNavigationView.menu[1].isVisible = mainViewModel.canShowSchedule
        supportActionBar?.hide()

        mainViewModel.loadingAnimationVisibility.observe(this, Observer { visibility ->
            loadingAnimation.visibility = visibility
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        supportActionBar?.show()
        bottomNavigationView.show()
        return findNavController(R.id.navHostFragment).navigateUp()
                || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }

    private val destinationChangedListener = NavController.OnDestinationChangedListener { _, destination, _ ->
        when(destination.id) {
            R.id.teamMembersFragment -> bottomNavigationView.hide()
            R.id.eventDetailFragment -> {
                supportActionBar?.hide()
                bottomNavigationView.hide()
            }
            R.id.eventsListFragment -> {
                supportActionBar?.hide()
                bottomNavigationView.show()
            }
            else -> {
                supportActionBar?.show()
                bottomNavigationView.show()
            }
        }
    }

    private fun BottomNavigationView.show() {
        mainViewModel.showBottomNav(this)
    }

    private fun BottomNavigationView.hide() {
        mainViewModel.hideBottomNav(this)
    }
}
