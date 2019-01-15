package com.cxz.wanandroid.utils

/**
 * describe :
 * author   : 马世豪 29350
 * time     : 2019/1/15 10:03
 */
/*
* 注解Activity setContentView(R.layout.main)  value = R.layout.main   contentID = R.id.linearlayout
* */
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ContentView(val value: Int, val contentID: Int = 0)
