package com.sun.module_util.log

import android.util.Log
import com.sun.module_util.BuildConfig

/**
 * @author sunxianglei
 * @date 2021/2/22
 * @desc 日志打印工具
 */

object MLog {
    private val DEBUG = BuildConfig.DEBUG;
    fun v(tag: String, msg: String) {
        if(DEBUG) {
            Log.v(tag, msg)
        }
    }
    fun d(tag: String, msg: String) {
        if(DEBUG) {
            Log.d(tag, msg)
        }
    }
    fun i(tag: String, msg: String) {
        if(DEBUG) {
            Log.i(tag, msg)
        }
    }
    fun w(tag: String, msg: String) {
        if(DEBUG) {
            Log.w(tag, msg)
        }
    }
    fun e(tag: String, msg: String) {
        if(DEBUG) {
            Log.e(tag, msg)
        }
    }

}