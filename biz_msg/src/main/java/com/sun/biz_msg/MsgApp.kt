package com.sun.biz_msg

import android.app.Application
import com.sun.export_biz_msg.MsgServiceUtil
import com.sun.module_common.BaseApp
import com.sun.module_util.log.MLog

/**
 * @author sunxianglei
 * @date 2021/2/24
 * @desc
 */
private const val TAG = "Msg_MsgApp"
class MsgApp: BaseApp {

    override fun onCreate(application: Application) {
        MLog.d(TAG, "BaseApp MsgApp init")
        MsgServiceUtil.setMsgService(MsgServiceImpl())
    }
}