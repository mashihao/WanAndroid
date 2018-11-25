package com.cxz.wanandroid.ui.activity

import android.widget.Button
import android.widget.Toast
import com.cxz.wanandroid.R
import com.cxz.wanandroid.base.BaseActivity
import com.cxz.wanandroid.utils.LogServiceUtil

class DevelopAct : BaseActivity() {


    override fun attachLayoutRes(): Int {
        return R.layout.activity_dev
    }

    override fun initData() {
    }

    override fun initView() {
        var reconnect: Button? = null
        reconnect = findViewById(R.id.reconnnect)
        reconnect.setOnClickListener {
            Toast.makeText(this, "fdsfds", Toast.LENGTH_SHORT).show()
            LogServiceUtil.connect()
        }
    }

    override fun start() {
    }
}
