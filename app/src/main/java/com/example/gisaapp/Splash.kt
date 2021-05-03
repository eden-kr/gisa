package com.example.gisaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.gisaapp.Adapter.GisaAdapter
import com.example.gisaapp.Contract.SplashContract
import com.example.gisaapp.Model.DAO.Gisa
import com.example.gisaapp.Presenter.SplashPresenter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_splash.*

class Splash : AppCompatActivity() ,SplashContract.View {
    lateinit var fireStore : FirebaseFirestore
    private var presenter : SplashContract.Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter = SplashPresenter()
        presenter?.attachView(this)
        fireStore = FirebaseFirestore.getInstance()

        presenter?.checkFirebase(fireStore)

    }


    override fun setSplash() {
        Handler().postDelayed(Runnable {
            startActivity(Intent(this,MainActivity::class.java))
        },300)
    }

    override fun setAdapter(list: ArrayList<Gisa>) {
        val adapter = GisaAdapter(this, list)
        gisaView.adapter = adapter
    }
}