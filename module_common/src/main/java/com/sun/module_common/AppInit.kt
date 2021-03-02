package com.sun.module_common

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.sun.module_util.log.MLog

/**
 * @author sunxianglei
 * @date 2021/2/23
 * @desc
 */
private const val TAG = "Common_AppCommon"
class AppCommon: BaseApp{
    override fun onCreate(application: Application) {
        MLog.d(TAG, "BaseApp AppCommon init")
        initARouter(application)
    }

    private fun initARouter(application: Application) {
        if(BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(application)
    }
}