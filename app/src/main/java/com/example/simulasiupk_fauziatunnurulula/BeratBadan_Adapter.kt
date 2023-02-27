package com.example.simulasiupk_fauziatunnurulula


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeratBadan_Adapter (private val dataSet: MutableList<Databb>):
RecyclerView.Adapter<BeratBadan_Adapter.beratbadanHolder>(){
    class beratbadanHolder(view: View) : RecyclerView.ViewHolder(view) {
        val namaa = view.findViewById<TextView>(R.id.txt_nama)
        val tinggii = view.findViewById<TextView>(R.id.txt_tinggiBadan)
        val hasil = view.findViewById<TextView>(R.id.txtBeratBadan)
        val hapus = view.findViewById<ImageView>(R.id.icDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): beratbadanHolder {
       val view = LayoutInflater.from(parent.context).inflate(
           R.layout.activity_berat_badan_adapter,parent, false
       )
        return beratbadanHolder(view)
    }

    override fun onBindViewHolder(holder: beratbadanHolder, position: Int) {
        val data = dataSet[position]
        holder.namaa.text = dataSet[position].nama
        holder.tinggii.text = dataSet[position].tingbad
        holder.hasil.text = dataSet[position].beratbadan
        holder.hapus.setOnClickListener{
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position, dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}