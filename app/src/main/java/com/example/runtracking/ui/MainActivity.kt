package com.example.runtracking.ui

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.runtracking.R
import com.example.runtracking.base.BaseActivity
import com.example.runtracking.databinding.ActivityMainBinding
import com.example.runtracking.utils.Constants
import com.example.runtracking.utils.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import com.example.runtracking.utils.TrackingUtility
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), EasyPermissions.PermissionCallbacks {

    private lateinit var navController: NavController

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)

        requestPermissions()

        navigationToTrackingFragmentIfNeeded(intent)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.runFragment, R.id.settingsFragment, R.id.statisticsFragment -> {
                    binding.bottomNavigationView.visibility = View.VISIBLE
                }
                else -> binding.bottomNavigationView.visibility = View.GONE
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigationToTrackingFragmentIfNeeded(intent)
    }

    private fun navigationToTrackingFragmentIfNeeded(intent : Intent?) {
        if (intent?.action == ACTION_SHOW_TRACKING_FRAGMENT){
            navController.navigate(R.id.action_global_trackingFragment)
        }
    }

    private fun requestPermissions() {
        if (TrackingUtility.hasLocationPermissions(this)){
            return
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q){
            EasyPermissions.requestPermissions(
                this,
                "You need to accept location permissions to use this app.",
                Constants.REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        }else{
            EasyPermissions.requestPermissions(
                this,
                "You need to accept location permissions to use this app.",
                Constants.REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }

    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {}

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if(EasyPermissions.somePermissionPermanentlyDenied(this, perms)){
            AppSettingsDialog.Builder(this).build().show()
        }else{
            requestPermissions()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }



}