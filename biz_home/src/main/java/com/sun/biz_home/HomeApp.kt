package com.sun.biz_home

import android.app.Application
import com.sun.module_common.BaseApp
import com.sun.module_util.log.MLog

/**
 * @author sunxianglei
 * @date 2021/2/23
 * @desc
 */
private const val TAG = "Home_HomeApp"
class HomeApp: BaseApp {
    override fun onCreate(application: Application) {
        MLog.d(TAG, "BaseApp HomeApp init")
    }

}