package com.sun.module_common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author sunxianglei
 * @date 2021/2/22
 * @desc activity基类
 */

open class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}