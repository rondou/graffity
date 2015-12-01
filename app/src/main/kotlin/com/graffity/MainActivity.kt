package com.graffity

//import kotlinx.android.synthetic.activity_main.hello as helloView
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger

open class MainActivity : FragmentActivity() {

    var fb_fragment : FBAuthFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) : Unit {
        super.onCreate(savedInstanceState)

        FacebookSdk.sdkInitialize(getApplicationContext());

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
