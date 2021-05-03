package com.example.gisaapp.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gisaapp.Model.DAO.Gisa
import com.example.gisaapp.R

class GisaAdapter(private val context : Context, private val list : ArrayList<Gisa>) : RecyclerView.Adapter<GisaAdapter.GisaHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GisaHolder, position: Int) {
        Log.e("TAG",list.size.toString())
        val data = list[position]

        holder.question.text = data.problem

        if(data.example.contains("http")){
            holder.exampleImage.visibility = View.VISIBLE
            Glide.with(context)
                .load(data.example)
                .into(holder.exampleImage)
        }else{
            holder.exampleImage.visibility = View.GONE
            holder.exampleText.text = data.example
        }

        if(data.image[position] !=null){
            holder.image.visibility = View.VISIBLE
            Glide.with(context)
                .load(data.image[position])
                .into(holder.image)
        }else{
            holder.image.visibility = View.INVISIBLE
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GisaHolder {
        return GisaHolder(LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false))
    }

    inner class GisaHolder(view : View) : RecyclerView.ViewHolder(view) {
        var question : TextView = view.findViewById(R.id.problem)
        var exampleImage : ImageView = view.findViewById(R.id.example_image)
        var exampleText : TextView = view.findViewById(R.id.example_text)
        var image : ImageView = view.findViewById(R.id.image)
    }
}