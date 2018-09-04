package com.pradeep.app.presentor.inteceptor

import android.app.AuthenticationRequiredException

/**
 * Created by pradeep on 9/12/2017.
 */

interface AuthenticateInterceptor {

    interface AuthenticateServiceCompleteListner {
        fun onSuccess()
        fun onFailure()
        fun onUserNameFailure()
        fun onUserPassFailure()
    }

    fun validateUser(userName: String, userPass: String, listner: AuthenticateServiceCompleteListner)
}
