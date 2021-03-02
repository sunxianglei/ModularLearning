package com.sun.biz_me

import android.app.Application
import com.sun.module_common.BaseApp
import com.sun.module_util.log.MLog

/**
 * @author sunxianglei
 * @date 2021/2/24
 * @desc
 */
private const val TAG = "Me_MeApp"
class MeApp: BaseApp {
    override fun onCreate(application: Application) {
        MLog.d(TAG, "BaseApp MeApp init")
    }
}