package com.pradeep.app.presentor.presentor.impl

import com.pradeep.app.view.AuthenticateView
import com.pradeep.app.presentor.inteceptor.AuthenticateInterceptor
import com.pradeep.app.presentor.inteceptor.impl.AuthenticateInterceptorImpl
import com.pradeep.app.presentor.presentor.AuthenticatePresentor

/**
 * Created by pradeep on 9/12/2017.
 */
class AuthenticatePresentorImpl : AuthenticatePresentor, AuthenticateInterceptor.AuthenticateServiceCompleteListner {

    var authInterceptor: AuthenticateInterceptorImpl? = null
    var authView: AuthenticateView? = null

    constructor(authView: AuthenticateView) {
        this.authView = authView;
        authInterceptor = AuthenticateInterceptorImpl()
    }

    override fun validate(userName: String, userPass: String) {
        authView?.showProgress()
        authInterceptor?.validateUser(userName, userPass, this);
    }

    override fun onFailure() {
        authView?.hideProgress()
    }

    override fun onSuccess() {
        authView?.hideProgress()
        authView?.navigate()
    }

    override fun onUserNameFailure() {
        authView?.hideProgress()
        authView?.onUserNameError()
    }

    override fun onUserPassFailure() {
        authView?.hideProgress()
        authView?.onUserPassError()
    }
}