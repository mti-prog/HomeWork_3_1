package com.geeks.homework_3_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.geeks.homework_3_1.data.keys.Keys
import com.geeks.homework_3_1.data.pref.onBoardSharedPreferences
import com.geeks.homework_3_1.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var  pref : onBoardSharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        supportFragmentManager.beginTransaction().replace(R.id.main_fragment, MainFragment()).commit()
    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        pref = onBoardSharedPreferences(this)

        if (pref.notEntered()){
            navController.navigate(R.id.boardFragment)
        }else{
            navController.navigate(R.id.mainFragment)
        }

    }
}