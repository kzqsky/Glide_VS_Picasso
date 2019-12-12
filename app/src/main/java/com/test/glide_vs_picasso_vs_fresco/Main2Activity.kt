package com.test.glide_vs_picasso_vs_fresco

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.File

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        showImage()
    }
    private fun showImage(){
        var url= Environment.getExternalStorageDirectory().path+"/tu/18.jpeg"
        Glide.with(this)
            .applyDefaultRequestOptions(
                 RequestOptions()
                    .format(DecodeFormat.PREFER_ARGB_8888))
            .load(Uri.fromFile(File(url)))
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(imageView)
//        Picasso.get().load(Uri.fromFile(File(url))).into(imageView)
    }
}
