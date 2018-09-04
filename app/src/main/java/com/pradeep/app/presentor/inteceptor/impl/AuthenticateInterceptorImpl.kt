package com.pradeep.app.presentor.inteceptor.impl

import android.os.Handler
import com.pradeep.app.presentor.inteceptor.AuthenticateInterceptor

/**
 * Created by pradeep on 9/12/2017.
 */
class AuthenticateInterceptorImpl : AuthenticateInterceptor {
    override fun validateUser(userName: String, userPass: String, listner: AuthenticateInterceptor.AuthenticateServiceCompleteListner) {
        Handler().postDelayed({
            if (userName.isEmpty())
                listner.onUserNameFailure()
            else if (userPass.isEmpty())
                listner.onUserPassFailure()
            else
                listner.onSuccess()
        }, 500)
    }
}