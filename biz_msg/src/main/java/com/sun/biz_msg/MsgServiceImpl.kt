package com.sun.biz_msg

import com.sun.export_biz_msg.IMsgService

/**
 * @author sunxianglei
 * @date 2021/2/25
 * @desc
 */
class MsgServiceImpl: IMsgService {
    override fun getMsgCount(): Int{
        return MsgCount.instance.getCount()
    }
}