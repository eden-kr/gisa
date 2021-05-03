package com.example.gisaapp.Contract

import com.example.gisaapp.Model.DAO.Gisa
import com.google.firebase.firestore.FirebaseFirestore

class SplashContract {
    interface View{
        fun setSplash()
        fun setAdapter(list : ArrayList<Gisa>)

    }
    interface Presenter{
        fun attachView(view : View)
        fun detachView()
        fun checkDB()
        fun checkFirebase(firestore: FirebaseFirestore)
        fun reload()
        fun download()
    }
}