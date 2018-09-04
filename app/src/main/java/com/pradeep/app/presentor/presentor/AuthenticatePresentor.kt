package com.pradeep.app.presentor.presentor

/**
 * Created by pradeep on 9/12/2017.
 */
interface AuthenticatePresentor {
    fun validate(userName: String, userPass: String)
}
