package com.cxz.wanandroid.mvp.model

import com.cxz.wanandroid.http.RetrofitHelper
import com.cxz.wanandroid.mvp.model.bean.ArticleResponseBody
import com.cxz.wanandroid.mvp.model.bean.HttpResult
import com.cxz.wanandroid.rx.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by chenxz on 2018/5/20.
 */
class ProjectListModel: CommonModel() {

    fun requestProjectList(page: Int, cid: Int): Observable<HttpResult<ArticleResponseBody>> {
        return RetrofitHelper.service.getProjectList(page, cid)
                .compose(SchedulerUtils.ioToMain())
    }

}