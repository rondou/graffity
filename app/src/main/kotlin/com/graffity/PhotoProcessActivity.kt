package com.graffity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.ViewGroup
import com.customview.StickerManager


/**
 * Created by rondouchen on 2015/12/10.
 */
class PhotoProcessActivity: AppCompatActivity() {
    var mStickerManager : StickerManager? = null
    //var mGpuImage : GPUImageView? = null
    var drawArea : ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) : Unit {
        super.onCreate(savedInstanceState)
        Log.d("xxxxxxxxxxxxxx", "xopopopopop")
        setContentView(R.layout.activity_image_process)
        //mGpuImage = findViewById(R.id.gpuimage) as GPUImageView
        drawArea = findViewById(R.id.drawing_view_container) as ViewGroup
        initView()
    }

    private fun initView()  {
        mStickerManager = StickerManager(drawArea)
        mStickerManager?.addSticker()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("xxxxxxxxxxxxxx","rddddddddddddesult")
        if (resultCode == Activity.RESULT_OK) {
            //Glide.with(this).load().into(mGpuImage)
        }
    }
}