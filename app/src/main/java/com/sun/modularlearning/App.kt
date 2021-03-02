package com.sun.modularlearning

import android.app.Application
import com.sun.module_common.BaseApp
import com.sun.module_util.log.MLog
import java.lang.Exception

/**
 * @author sunxianglei
 * @date 2021/2/23
 * @desc
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initModuleApp(this)
    }

    private fun initModuleApp(application: Application) {
        try {
            for(appName in moduleInitArr) {
                val clazz = Class.forName(appName)
                val module = clazz.getConstructor().newInstance() as BaseApp
                module.onCreate(application)
            }
        }catch (e: Exception) {
            e.printStackTrace()
            MLog.e("App", "init module app have exception")
        }
    }

}