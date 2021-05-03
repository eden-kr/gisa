package com.example.gisaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.gisaapp.Adapter.GisaAdapter
import com.example.gisaapp.Fragment.MainFragment1
import com.example.gisaapp.Fragment.MainFragment2
import com.example.gisaapp.Fragment.MainFragment3
import com.example.gisaapp.Fragment.MainFragment4
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    var transcation : FragmentTransaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navbar.setOnNavigationItemSelectedListener(this)

        transcation = supportFragmentManager.beginTransaction()
        transcation?.add(R.id.main_fragment,MainFragment1())?.commit()


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        transcation = supportFragmentManager.beginTransaction()
        when(item.itemId){
            R.id.nav1 -> {
                transcation?.replace(R.id.main_fragment,MainFragment1())?.commitAllowingStateLoss()

                return true
            }
            R.id.nav2 ->{
                transcation?.replace(R.id.main_fragment, MainFragment2())?.commitAllowingStateLoss()
                return true
            }
            R.id.nav3 -> {
                transcation?.replace(R.id.main_fragment, MainFragment3())?.commitAllowingStateLoss()

                return true
            }
            R.id.nav4 ->{
                transcation?.replace(R.id.main_fragment, MainFragment4())?.commitAllowingStateLoss()

                return true
            }
        }
        return false
    }

}