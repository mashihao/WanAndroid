package com.cxz.wanandroid.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * describe :
 * author   : 马世豪 29350
 * time     : 2018/11/6 17:04
 */
class AppActivityListener : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(act: Activity?, p1: Bundle?) {
        ActivityStack.getInstance().pushActivity(act)
    }

    override fun onActivityPaused(p0: Activity?) {


    }

    override fun onActivityResumed(p0: Activity?) {
    }

    override fun onActivityStarted(p0: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
        if (activity != null) {
            ActivityStack.getInstance().removeActivity(activity)
        }
    }

    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
    }

    override fun onActivityStopped(p0: Activity?) {
    }

}