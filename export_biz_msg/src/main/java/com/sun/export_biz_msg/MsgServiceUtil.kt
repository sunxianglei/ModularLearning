package com.sun.export_biz_msg

import com.alibaba.android.arouter.launcher.ARouter
import com.sun.module_common.RouterPath

/**
 * @author sunxianglei
 * @date 2021/2/25
 * @desc
 */
object MsgServiceUtil {
    private lateinit var msgService: IMsgService
    /**
     * 通过ARouter方式进行通信
     */
    fun onCountFromHome(count: Int) {
        getMsgProvider().onCountFromHome(count)
    }

    private fun getMsgProvider(): IMsgProvider {
        return ARouter.getInstance().build(RouterPath.MSG_PROVIDER).navigation() as IMsgProvider
    }

    fun setMsgService(msgService: IMsgService) {
        this.msgService = msgService
    }

    fun getMsgCount(): Int{
        return msgService.getMsgCount()
    }
}