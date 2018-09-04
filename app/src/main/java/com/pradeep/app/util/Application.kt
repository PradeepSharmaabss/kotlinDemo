package com.pradeep.app.util

import android.app.Application
import android.content.Context
import android.util.Log

/**
 * Created by pradeep on 9/11/2017.
 */

class Application : Application() {
    public var context: Context? = null

    private object Holder {
        val INSTANCE = Application()
    }

    companion object {
        val instance = Application by lazy { Holder.INSTANCE }

        private infix fun by(lazy: Lazy<Application>): Any {
            return lazy
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this;
    }
}
