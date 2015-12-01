package com.graffity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.login.widget.LoginButton
import java.util.*

/**
 * Created by rondouchen on 2015/12/1.
 */
open class FBAuthFragment: Fragment() {

    public override fun onCreateView(inflater : LayoutInflater?, container: ViewGroup?,
                                     savedInstanceState : Bundle?) : View {
        val view = inflater?.inflate(R.layout.activity_fb_auth_activity, container, false)
        val authButton : LoginButton = view?.findViewById(R.id.Button02) as LoginButton
        authButton.setFragment(this)
        authButton.setReadPermissions(Arrays.asList("email", "user_birthday"));

        return view!!
    }

}