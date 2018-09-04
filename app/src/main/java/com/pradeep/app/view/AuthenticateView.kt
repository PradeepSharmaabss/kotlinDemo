package com.pradeep.app.view

/**
 * Created by PRADEEP on 9/12/2017.
 */
interface AuthenticateView {
    fun onUserNameError()
    fun onUserPassError()
    fun showProgress()
    fun hideProgress()
    fun navigate()
}