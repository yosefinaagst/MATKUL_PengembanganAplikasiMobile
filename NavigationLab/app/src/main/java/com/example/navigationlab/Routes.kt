package com.example.navigationlab

import android.adservices.adid.AdId

object Routes {
    const val HOME      = "home"
    const val PROFILE   = "profile"
    const val DETAIL    = "detail/{studentId}"

    fun detail(studentId: Int): String = "detail/ $studentId"
}