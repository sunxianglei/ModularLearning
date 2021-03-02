package com.sun.export_biz_msg

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @author sunxianglei
 * @date 2021/2/25
 * @desc
 */
interface IMsgProvider: IProvider {
    fun onCountFromHome(count: Int = 1)
}