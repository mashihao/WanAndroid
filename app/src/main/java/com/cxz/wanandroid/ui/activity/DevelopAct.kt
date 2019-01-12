package com.cxz.wanandroid.ui.activity

import android.widget.Button
import android.widget.Toast
import com.cxz.wanandroid.R
import com.cxz.wanandroid.base.BaseActivity
import com.cxz.wanandroid.utils.DevelopHelp
import com.cxz.wanandroid.utils.LogServiceUtil
@DevelopHelp.UnDevelopActivity
class DevelopAct : BaseActivity() {


    override fun attachLayoutRes(): Int {
        return R.layout.activity_dev
    }

    override fun initData() {
    }

    override fun initView() {
        //重新链接， 重连机制
        var reconnect: Button? = null
        reconnect = findViewById(R.id.reconnnect)
        reconnect.setOnClickListener {
            LogServiceUtil.connect()
        }
    }

    override fun start() {
    }
}
