package com.cxz.wanandroid.mvp.model

import com.cxz.wanandroid.http.RetrofitHelper
import com.cxz.wanandroid.mvp.model.bean.HttpResult
import com.cxz.wanandroid.mvp.model.bean.LoginData
import com.cxz.wanandroid.rx.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by chenxz on 2018/6/3.
 */
class RegisterModel {

    fun registerWanAndroid(username: String, password: String, repassword: String): Observable<HttpResult<LoginData>> {
        return RetrofitHelper.service.registerWanAndroid(username, password, repassword)
                .compose(SchedulerUtils.ioToMain())
    }

}