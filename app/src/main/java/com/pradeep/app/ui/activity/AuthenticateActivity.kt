package com.pradeep.app.ui.activity

import android.app.ProgressDialog
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.pradeep.app.R
import com.pradeep.app.presentor.presentor.impl.AuthenticatePresentorImpl
import com.pradeep.app.view.AuthenticateView

class AuthenticateActivity : BaseActivity(), AuthenticateView {


    private var etUserName: EditText? = null
    private var etUserPass: EditText? = null
    private var btnLogin: Button? = null

    override fun onNetworkChange(isConnected: Boolean) {

    }

    private var authPresentor: AuthenticatePresentorImpl? = null

    override fun layoutAdded(savedInstanceState: android.os.Bundle?) {
        initViews()
        authPresentor = AuthenticatePresentorImpl(this)
        listner()
    }

    override fun setLayout(): Int {
        return R.layout.activity_landing;
    }

    fun initViews() {
        etUserName = findViewById(R.id.et_userName)
        etUserPass = findViewById(R.id.et_userPass)
        btnLogin = findViewById(R.id.btn_login)
    }


    override fun onUserNameError() {
        etUserName?.setError("Invalid Username")
        etUserName?.requestFocus()
    }

    override fun onUserPassError() {
        etUserPass?.setError("Invalid Password")
        etUserPass?.requestFocus()
    }

    override fun showProgress() {
        pbDialog = ProgressDialog.show(this, "", "Please wait...")
    }

    override fun hideProgress() {
        pbDialog!!.hide()
    }

    override fun navigate() {
        Toast.makeText(this,"Credential Valid",Toast.LENGTH_SHORT).show()
    }


    private var pbDialog: ProgressDialog? = null

    fun listner() {
        btnLogin?.setOnClickListener {

            authPresentor?.validate(getText(etUserName), getText(etUserPass))
        }
    }
}
