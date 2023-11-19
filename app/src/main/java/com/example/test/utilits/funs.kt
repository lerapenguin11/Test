package com.example.test.utilits

import androidx.fragment.app.Fragment
import com.example.test.R

fun replaceFragmentMain(fr: Fragment, aSt: Boolean = true) {
    if (aSt) {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.main_layout,
                fr
            ).commit()
    } else {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_layout,
                fr
            ).commit()
    }
}