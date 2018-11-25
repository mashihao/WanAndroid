package com.cxz.wanandroid.mvp.presenter

import com.cxz.wanandroid.base.BasePresenter
import com.cxz.wanandroid.http.exception.ExceptionHandle
import com.cxz.wanandroid.mvp.contract.CommonContract
import com.cxz.wanandroid.mvp.model.CommonModel

/**
 * Created by chenxz on 2018/6/10.
 */
open class CommonPresenter<V : CommonContract.View>
    : BasePresenter<V>(), CommonContract.Presenter<V> {

    private val mModel: CommonModel by lazy {
        CommonModel()
    }

    //添加喜欢的
    override fun addCollectArticle(id: Int) {
        val disposable = mModel.addCollectArticle(id)
                .subscribe({ results ->
                    mRootView?.run {
                        if (results.errorCode != 0) {
                            showError(results.errorMsg)
                        } else {
                            showCollectSuccess(true)
                        }
                    }
                }, { t ->
                    mRootView?.apply {
                        hideLoading()
                        showError(ExceptionHandle.handleException(t))
                    }
                })
        addSubscription(disposable)
    }

    override fun cancelCollectArticle(id: Int) {
        val disposable = mModel.cancelCollectArticle(id)
                .subscribe({ results ->
                    mRootView?.run {
                        if (results.errorCode != 0) {
                            showError(results.errorMsg)
                        } else {
                            showCancelCollectSuccess(true)
                        }
                    }
                }, { t ->
                    mRootView?.apply {
                        hideLoading()
                        showError(ExceptionHandle.handleException(t))
                    }
                })
        addSubscription(disposable)
    }

}