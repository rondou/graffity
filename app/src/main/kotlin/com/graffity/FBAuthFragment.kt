package com.graffity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import retrofacebook.Facebook

//import kotlinx.android.synthetic.activity_fb_auth_activity.Button02 as authButton

/**
 * Created by rondouchen on 2015/12/1.
 */
open class FBAuthFragment: Fragment() {

    val facebook: Facebook by lazy { Facebook.create(activity) }

    var fbImage : ImageView? = null

    public override fun onCreateView(inflater : LayoutInflater?, container: ViewGroup?,
                                     savedInstanceState : Bundle?) : View {
        val view: View? = inflater?.inflate(R.layout.activity_fb_auth_activity, container, false)
        //val authButton: LoginButton? = view?.findViewById(R.id.Button02) as LoginButton
        fbImage = view?.findViewById(R.id.image) as ImageView?

        //val myPosts = facebook.getPosts()
        facebook.getUploadedPhotos().take(1).forEach {
            Log.d("FBauthFragment", "photoImageURL = 0" + it)
            Log.d("FBauthFragment", "photoImageURL = 1" + it.images())
            Log.d("FBauthFragment", "photoImageURL = 2" + it.images()?.get(0))
            Log.d("FBauthFragment", "photoImageURL = 3" + it.images()?.get(0)?.source())
            Glide.with(getActivity()).load(it.images()?.get(0)?.source()).into(fbImage)
        }

        return view!!
    }
}