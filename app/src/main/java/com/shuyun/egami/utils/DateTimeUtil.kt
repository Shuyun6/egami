package com.shuyun.egami.utils

import java.text.SimpleDateFormat
import java.util.Locale

object DateTimeUtil {

    val yymmddDate: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            return sdf.format(System.currentTimeMillis())
        }

}
