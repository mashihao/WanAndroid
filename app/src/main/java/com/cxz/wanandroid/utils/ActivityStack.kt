package com.cxz.wanandroid.utils

import android.app.Activity
import android.support.annotation.MainThread
import java.util.*

/**
 * describe : Activity 栈 管理
 * author   : 马世豪 29350
 * time     : 2018/11/6 15:55
 */
class ActivityStack private constructor() {

    private fun ActivityStack() {}

    /*
    * 不关闭某一个Activity
    * */
    @Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class UnFinishActivity(val value: String)


    /**
     * 你可以利用这个注解标记的Activity,一个完整的业务流程用同一个标记,
     * 这样子可以让你在这个流程结束的时候,
     * 可以准确无误的杀死这个流程上的所有Activity
     */
    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class ActivityAction(val value: Array<String>)


    /*
    *  同一个界面可以多次显示在界面
    * */
    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class ActivityCanRepeat


    /**
     * the stack will be save all reference of Activity
     */
    private val activityStack = Stack<Activity>()


    // 单例模式
    companion object {
        private var ActivityStackInstance: ActivityStack? = null

        @MainThread
        @Synchronized
        fun getInstance(): ActivityStack {
            if (ActivityStackInstance == null) {
                ActivityStackInstance = ActivityStack()
            }
            return ActivityStackInstance as ActivityStack
        }
    }

    private val canNotDestoryActivities = arrayOf("com.jdpaysdk.author.AuthorActivity")

    /**
     * 进入栈
     */
    @Synchronized
    fun pushActivity(activity: Activity?) {

        if (activity == null) return
        if (activityStack.contains(activity)) return

        // 检查顶层的这个是不是和当前要进入的这个是一个Class,这是一个折中的方式,下一步,让每一个视图都继承baseView中的父类,在父类中对点击事件进行处理

        val canOpenMore = activity.javaClass.isAnnotationPresent(ActivityCanRepeat::class.java)

        if (activityStack.size > 0 && !canOpenMore) {

            var isFinish = false

            val preAct = activityStack[activityStack.size - 1]

            if (preAct.javaClass == activity.javaClass) {
                isFinish = true
            }

            // 如果匹配到名称就放过,不要销毁掉
            for (className in canNotDestoryActivities) {
                if (className == preAct.javaClass.name) {
                    isFinish = false
                    break
                }
            }

            // 如果需要销毁前一个
            if (isFinish) {
                if (!preAct.isFinishing) {
                    preAct.finish()
                }
                removeActivity(preAct)
            }

        }

        activityStack.add(activity)

    }

    /**
     * you can use Annotation [ActivityAction] to flag your Activity [Activity]
     * and write your custom action.
     * and then you can call this method delivery a action,such as "selfOrderAction" .
     * this method will finish all Activity which was marked with Annotation [ActivityAction]
     * and the Annotation's value() is equals to "selfOrderAction"
     *
     * @param action the custom action
     */
    @Synchronized
    fun popActivityWithAction(action: String) {
        outter@ for (i in activityStack.indices.reversed()) {
            val currentAct = activityStack.get(i) ?: continue
            val activityAction = currentAct.javaClass.getAnnotation(ActivityAction::class.java)
                    ?: continue
            val values = activityAction.value ?: continue
            inner@ for (value in values) {
                if (value == action) {
                    currentAct.finish()
                    removeActivity(currentAct)
                    break@inner
                }
            }
        }
    }

    /**
     * will destory all Activity except the activity is masked with Annotation [UnFinishActivity]
     * see [.forcePopAllActivity]
     *
     */
    @Synchronized
    fun popAllActivity() {

        for (i in activityStack.indices.reversed()) {
            val activity = activityStack[i] ?: continue

            if (activity.javaClass.isAnnotationPresent(UnFinishActivity::class.java)) continue

            removeActivity(activity)

            if (!activity.isFinishing) {
                activity.finish()
            }

        }

    }


    /**
     * will finish all Activity
     *
     */
    @Synchronized
    fun forcePopAllActivity() {
        forcePopAllActivityWithFalg()
    }


    /**
     * will finish all Activity except the Activities
     * which UnFinishActivity's value is equal to parameter 'flag'
     *
     * @param flags
     */
    @Synchronized
    fun forcePopAllActivityWithFalg(vararg flags: String) {

        for (i in activityStack.indices.reversed()) {

            val activity = activityStack[i] ?: continue

            var isFinish = true

            val unFinishActivity = activity.javaClass.getAnnotation(UnFinishActivity::class.java)
            if (unFinishActivity != null) {
                // if the flag string is the same as value,the Activity will not be finish
                val value = unFinishActivity.value
                for (j in flags.indices) {
                    if (value == flags[j]) {
                        isFinish = false
                        break
                    }
                }
            }

            if (isFinish) {
                if (!activity.isFinishing) {
                    activity.finish()
                }
                activityStack.removeAt(i)
            }

        }

    }

    /**
     * remove the reference of Activity
     *
     */
    @Synchronized
    fun removeActivity(activity: Activity) {
        activityStack.remove(activity)
    }

    /**
     * @return whether the the size of stack of Activity is zero or not
     */
    @Synchronized
    fun isEmpty(): Boolean {
        return activityStack.size == 0
    }

    /**
     * 主界面是否存在
     *
     * @return
     */
    @Synchronized
    fun isActivityExit(clazz: Class<*>): Boolean {
        if (activityStack.size == 0) {
            return false
        }

        var result = false

        for (act in activityStack) {
            if (act.javaClass == clazz) {
                result = true
                break
            }
        }

        return result

    }

    /**
     * @return the size of stack of Activity
     */
    @Synchronized
    fun getSize(): Int {
        return activityStack.size
    }

    /**
     * @return the Activity On the top
     */
    @Synchronized
    fun getTopActivity(): Activity? {
        return if (isEmpty()) null else activityStack[activityStack.size - 1]
    }


}