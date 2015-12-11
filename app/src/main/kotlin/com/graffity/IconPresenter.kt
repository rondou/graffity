package com.graffity

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.infstory.v7.widget.Presenter
import retrofacebook.Photo

/**
 * Created by rondouchen on 2015/12/6.
 */
class IconPresenter(itemView: View?) : Presenter<Photo>(itemView) {
    val icon: ImageView? = itemView?.findViewById(R.id.icon) as ImageView?
    var intent : Intent? = null

    override fun onBind(position: Int, item: Photo?) {
        Glide.with(itemView.context).load(item?.images()?.get(0)?.source()).into(icon)

        icon?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                Log.d("xxxxxxxxxxxxxxxxxx","----------------------")
                Log.d("xxxxxxxxxxxxxxxxxx","position = " + position)
                intent = Intent()
                intent?.setClass(itemView.context, PhotoProcessActivity::class.java)
                intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent?.putExtra("position", position)
                itemView.context.startActivity(intent)

            }
        })
    }
}
