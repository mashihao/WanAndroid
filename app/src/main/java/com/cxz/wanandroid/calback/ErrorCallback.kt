package com.cxz.wanandroid.calback

import com.cxz.wanandroid.R
import com.kingja.loadsir.callback.Callback

class ErrorCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_error
    }
}