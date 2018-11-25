package com.cxz.wanandroid

import org.junit.Test
import kotlin.reflect.KProperty

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    // 定义包含属性委托的类
    class Example {
        var p: String by Delegate("")
    }

    // 委托的类
    class Delegate(val name: String) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            when (name) {
                "1" -> return "1"
                "2" -> return "2"
                else
                -> return "null"

            }
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$thisRef 的 ${property.name} 属性赋值为 $value")
        }
    }


    @Test
    fun addition_isCorrect() {

        var name :String = " 123123213"

        name.run {
            print("fdsafdsfsdf")
        }
    }

}



