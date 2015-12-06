package com.graffity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.infstory.v7.widget.ListRecyclerAdapter
import retrofacebook.Facebook
import retrofacebook.Photo


//import kotlinx.android.synthetic.activity_fb_auth_activity.Button02 as authButton

/**
 * Created by rondouchen on 2015/12/1.
 */
open class FBAuthFragment: Fragment() {

    val facebook: Facebook by lazy { Facebook.create(activity) }

    var fbImage : ImageView? = null
    var listView : RecyclerView? = null

    public override fun onCreateView(inflater : LayoutInflater?, container: ViewGroup?,
                                     savedInstanceState : Bundle?) : View? {
        val view: View? = inflater?.inflate(R.layout.activity_fb_auth_activity, container, false)
        //val authButton: LoginButton? = view?.findViewById(R.id.Button02) as LoginButton
        fbImage = view?.findViewById(R.id.image) as ImageView
        listView = view?.findViewById(R.id.list_view) as RecyclerView?

        /*
        java.util.List<User> users = users.add("Andrew", "https://xxx.jpg")
        java.util.List<User> users = users.add("Andrew", "https://xxx.jpg")
        users = fb.getFriends();
        listView <= users?
        itemView <= user
        layout.item_user.xml
        [itemView1] -> data1
        [itemView2] -> data2
        [itemView2] -> data3
        [UserView] -> user1
        */

        val listAdapter: ListRecyclerAdapter<Photo, IconPresenter> = ListRecyclerAdapter.create()
        listAdapter.createPresenter { parent, viewType ->
            IconPresenter(LayoutInflater.from(context).inflate(R.layout.item_icon, parent, false))
        }

        listView?.setLayoutManager(LinearLayoutManager(activity));

        //val myPosts = facebook.getPosts()
        facebook.getUploadedPhotos().take(32).toList().subscribe ({
            listAdapter.getList().addAll(it) // List<Photo>
        }, {}, {
            listView?.setAdapter(listAdapter);
        })

        /*
        facebook.getUploadedPhotos().take(32).forEach { it ->
        Log.d("FBauthFragment", "photoImageURL = 0" + it) photo.images()
        Log.d("FBauthFragment", "photoImageURL = 1" + it.images()) List<Image>
        Log.d("FBauthFragment", "photoImageURL = 2" + it.images()?.get(0)) List<Image>.get(0)
        Log.d("FBauthFragment", "photoImageURL = 3" + it.images()?.get(0)?.source()) Image.source()
        Glide.with(getActivity()).load(it.images()?.get(0)?.source()).into(fbImage)
        */

        return view
    }

}