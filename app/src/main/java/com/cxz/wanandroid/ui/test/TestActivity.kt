package com.cxz.wanandroid.ui.test

import android.widget.ListView
import com.cxz.wanandroid.R
import com.cxz.wanandroid.base.BaseSwipeBackActivity

class TestActivity : BaseSwipeBackActivity() {

    private var list: ListView? = null
    override fun initData() {
    }

    override fun start() {
    }

    override fun initView() {
        list = findViewById(R.id.list)
        var datas = ArrayList<String>()
        for (i in 0..10) {
            datas.add("item" + i)
        }
    }

    override fun attachLayoutRes(): Int = R.layout.activity_test
}
