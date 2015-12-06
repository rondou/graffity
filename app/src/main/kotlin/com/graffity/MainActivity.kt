package com.graffity

//import kotlinx.android.synthetic.activity_main.hello as helloView
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.facebook.appevents.AppEventsLogger
import retrofacebook.Facebook

open class MainActivity : FragmentActivity() {

    var fb_fragment : FBAuthFragment? = null

    val facebook: Facebook by lazy { Facebook.create(this) }

    override fun onCreate(savedInstanceState: Bundle?) : Unit {
        super.onCreate(savedInstanceState)


        val myPosts = facebook.getPosts()
        myPosts.take(10).forEach {
            //Log.d("FacebookActivity", "id = " + it.id())
            //Log.d("FacebookActivity", "message = " + it.message())

        }


        if (savedInstanceState == null) {
            fb_fragment = FBAuthFragment()
            getSupportFragmentManager()?.beginTransaction()
                    ?.add(android.R.id.content, fb_fragment)?.commit();
        } else {
            fb_fragment = getSupportFragmentManager()?.findFragmentById(android.R.id.content) as FBAuthFragment
        }
        //setContentView(R.layout.activity_main)
        //helloView.setText("yo")
    }

    @Override
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("xxxxxxxxxxxxxx", "onActivityResult" )
        facebook!!.onActivityResult(requestCode, resultCode, data)
    }

    override fun onResume() {
        super.onResume()

        AppEventsLogger.activateApp(this)
    }

    override fun onPause() {
        super.onPause()

        AppEventsLogger.deactivateApp(this)
    }

    /*verticalLayout{
        padding = dip(30)
        val boimageView = imageView(R.mipmap.po_cup).lparams {
            gravity = Gravity.CENTER
        }

        val avatar = imageView().lparams(width = dip(48), height = dip (48))

        editText {
            hint = "Name"
            textSize = 24f
        }
        editText {
            hint = "Password"
            textSize = 24f
        }
        button("Login") {
            textSize = 26f
            onClick {
                avatar.setImageView(R.mipmap.po_cup)
            }
        }
    }*/
}
