package com.sun.biz_msg

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.sun.export_biz_msg.IMsgProvider
import com.sun.module_common.RouterPath

/**
 * @author sunxianglei
 * @date 2021/2/25
 * @desc
 */
@Route(path = RouterPath.MSG_PROVIDER)
class MsgProviderImpl: IMsgProvider {
    override fun onCountFromHome(count: Int) {
        MsgCount.instance.addCount(count)
    }

    override fun init(context: Context?) {
        // 对象被初始化时调用
    }

}