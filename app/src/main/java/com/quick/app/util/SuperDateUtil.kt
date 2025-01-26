package com.quick.app.util

import android.icu.util.Calendar

//静态工具类
object SuperDateUtil {
    /**
     *
     */
    fun currentYear():Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }
}