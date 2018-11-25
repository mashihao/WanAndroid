package com.cxz.wanandroid.utils

import com.google.gson.Gson

/**
 * TODO
 * author : 马世豪 29350
 * time   : 2018/11/13
 * version: 1.0
 */
class ObjectToJson {
    companion object {
        /**
         * javabean to json
         *
         * @param person
         * @return
         */
        fun javabeanToJson(person: Any): String {
            val gson = Gson()
            return gson.toJson(person)
        }
    }
}