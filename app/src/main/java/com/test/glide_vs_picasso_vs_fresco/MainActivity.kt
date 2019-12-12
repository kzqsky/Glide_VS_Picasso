package com.test.glide_vs_picasso_vs_fresco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showImage()
    }

   private fun showImage(){
        var url="https://desk-fd.zol-img.com.cn/t_s4096x2160c5/g1/M0B/00/03/ChMljV11uSyIL-KnADbfG7UlhS0AAPvBwIDUYcANt8z459.jpg"
        Glide.with(this).load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView_Glide)

        Picasso.get().load(url).into(imageView_Picasso)
    }
}
