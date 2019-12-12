package com.test.glide_vs_picasso_vs_fresco

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.item_image.view.*
import java.io.File


class Main4Activity : AppCompatActivity() {

    var filePath = Environment.getExternalStorageDirectory().path + "/tu/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        initView()
    }

    private fun initView() {
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter()

    }


    inner class RecyclerViewAdapter : RecyclerView.Adapter<MViewHolder>() {
        var imageList = listOf(
            "1.jpg",
            "2.jpg",
            "3.jpg",
            "4.jpg",
            "5.jpg",
            "6.jpg",
            "7.jpg",
            "8.jpg",
            "9.jpg",
            "10.jpg",
            "11.jpg",
            "12.jpg",
            "13.jpg",
            "14.jpg",
            "15.jpg",
            "16.jpg",
            "17.jpg",
            "18.jpeg",
            "19.jpeg",
            "20.jpeg",
            "21.jpeg",
            "22.jpeg",
            "23.jpeg",
            "24.jpg",
            "25.jpg"
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
            return MViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_image, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return imageList.size
        }

        override fun onBindViewHolder(holder: MViewHolder, position: Int) {
            holder.showImage(imageList[position])
        }

    }

    inner class MViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.imageView
        fun showImage(fileName: String) {

//            Glide.with(itemView.context)
//                .applyDefaultRequestOptions(
//                    RequestOptions()
//                        .format(DecodeFormat.PREFER_ARGB_8888)
//                )
//                .load(Uri.fromFile(File(filePath + fileName)))
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .into(imageView)
//        }

            Picasso.get().load(Uri.fromFile(File(filePath + fileName)))
                .into(imageView)
    }
    }
}

