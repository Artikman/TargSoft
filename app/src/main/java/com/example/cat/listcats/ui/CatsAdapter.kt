package com.example.cat.listcats.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cat.R
import com.example.cat.data.CatImage
import kotlinx.android.synthetic.main.item_cat.view.*

class CatsAdapter : RecyclerView.Adapter<CatsAdapter.ViewHolder>() {

    private var catsList: List<CatImage> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            inflater.inflate(R.layout.item_cat, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return catsList.size
    }

    fun setCatslist(catsList: List<CatImage>) {

        this.catsList = catsList
        notifyDataSetChanged()
    }

    fun getCatsList(): List<CatImage> {
        return catsList
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val catImage = catsList[position]

        Glide.with(holder.image)
            .load(catImage.url)
            .into(holder.image)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.item_image

    }

}