package com.cxz.wanandroid.mvp.model

import com.cxz.wanandroid.http.RetrofitHelper
import com.cxz.wanandroid.mvp.model.bean.ArticleResponseBody
import com.cxz.wanandroid.mvp.model.bean.HttpResult
import com.cxz.wanandroid.rx.SchedulerUtils
import io.reactivex.Observable

class SearchListModel {

    fun queryBySearchKey(page: Int, key: String): Observable<HttpResult<ArticleResponseBody>> {
        return RetrofitHelper.service.queryBySearchKey(page, key)
                .compose(SchedulerUtils.ioToMain())
    }

}