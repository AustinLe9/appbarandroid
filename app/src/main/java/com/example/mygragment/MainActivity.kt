package com.example.mygragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val hostfragment=supportFragmentManager.findFragmentById(R.id.navhost) as NavHostFragment
        val navigationcontroller=hostfragment.navController
        val navbar=findViewById<BottomNavigationView>(R.id.bottom_navbar)
        navbar.setOnApplyWindowInsetsListener(null)
        navbar.setupWithNavController(navigationcontroller)

// function to select the right clicked buttom
        navbar.setOnItemSelectedListener { item ->
            if (item.itemId != navbar.selectedItemId) {
              // navbar.popBackStack(item.itemId, inclusive = false)
                val fragmentId = when(item.itemId) {
                    R.id.Navigation_home -> R.id.fragmentA
                    R.id.Navigation_dashboard -> R.id.fragmentB
                    R.id.Navigation_profile -> R.id.fragmentC
                    else -> R.id.fragmentA
                }
                navigationcontroller.navigate(fragmentId)
            }
            true
        }
    }



}


