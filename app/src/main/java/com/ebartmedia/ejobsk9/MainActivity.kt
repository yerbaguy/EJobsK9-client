package com.ebartmedia.ejobsk9

import android.app.Activity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.ebartmedia.ejobsk9.ui.another.AnotherFragment
import com.ebartmedia.ejobsk9.ui.categories.CategoriesFragment
import com.ebartmedia.ejobsk9.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var categoriesFragment: CategoriesFragment
    lateinit var homeFragment: HomeFragment
    lateinit var anotherFragment: AnotherFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_another, R.id.nav_categories, R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        init()
      //  displayScreen(-1)

//        homeFragment = HomeFragment()
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.nav_host_fragment, homeFragment)
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun init() {

        var toggle = ActionBarDrawerToggle(Activity(), drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

    }



//    fun displayScreen(id:Int) {
//
//       val fragment=  when (id) {
//
//           R.id.nav_categories -> {
//
//               CategoriesFragment()
//
//           }
//
//


//            else -> {
//
//                HomeFragment()
//
//            }
//        }
//
//        drawer_layout.closeDrawer(GravityCompat.START)
//
//        return true

//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.nav_host_fragment, fragment)
//            .commit()
 //   }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {


        when (p0.itemId) {

            R.id.nav_categories -> {

               categoriesFragment = CategoriesFragment()
               // categoriesFragment = HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, categoriesFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.nav_another -> {

                anotherFragment = AnotherFragment()
                // categoriesFragment = HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, anotherFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()

            }

           // else -> HomeFragment()
        }


      //  displayScreen(p0.itemId)

        drawer_layout.closeDrawer(GravityCompat.START)

        return true;
    }


}
