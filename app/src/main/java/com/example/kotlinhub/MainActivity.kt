package com.example.kotlinhub

import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.kotlinhub.activities.KotlinCodes
import com.example.kotlinhub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$TAG:onCreate")

        KotlinCodes.create()

        try {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            //navController = navHostFragment.navController

            val toolbar = binding.toolbarMain
            setSupportActionBar(toolbar)

            navController = findNavController(R.id.nav_host_fragment)

            setupActionBarWithNavController(navController)
            setupSmoothBottomMenu()

        } catch (e: Exception) {
            Log.d(TAG, "Exception Found: $e")
        }

    }

    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.bottom_navigation_menu)
        val menu = popupMenu.menu
        binding.bottomBar.setupWithNavController(menu, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$TAG:onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$TAG:onDestroy")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$TAG:onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$TAG:onPause")
    }

    private var exitTime: Long = 0
    private fun doExitApp() {
        if((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "Press again to exit app", Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            this.finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}