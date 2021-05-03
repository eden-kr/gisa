package com.example.gisaapp.Presenter

import android.util.Log
import com.example.gisaapp.Contract.SplashContract
import com.example.gisaapp.Model.DAO.Gisa
import com.example.gisaapp.Model.Database.GisaDB
import com.google.firebase.firestore.FirebaseFirestore


class SplashPresenter : SplashContract.Presenter {
    private var view : SplashContract.View? = null
    private val GisaDB by lazy { GisaDB() }

    override fun attachView(view: SplashContract.View) {
        this.view = view
    }
    override fun detachView() {
        view = null
    }

    override fun checkDB() {

    }

    override fun checkFirebase(firestore: FirebaseFirestore) {
        val list = arrayListOf<Gisa>()
        firestore.collection("일반기계기사")
            .document("재료역학")
            .collection("20200926")
            .document("20200926")
            .get().addOnSuccessListener {
                if(it!= null){
                    it.data?.forEach {
                        var gisa = Gisa()

                        if(it.key.contains("e")){
                            gisa.example = it.value as String
                        }else if(it.key.contains("p")){
                            gisa.problem = it.value as String
                        }else if(it.key.contains("i")){
                            var num = it.key.replace(("[^\\d.]").toRegex(), "").toInt()
                            gisa.image[num] = it.value as String
                        }

                        Log.e("TAG","key : &${it.key} / value : ${it.value}")
                        list.add(gisa)
                    }
                    view?.setAdapter(list)
                }
            }.addOnFailureListener {
                it.printStackTrace()
            }
    }

    override fun reload() {
        TODO("Not yet implemented")
    }

    override fun download() {
        TODO("Not yet implemented")
    }
}