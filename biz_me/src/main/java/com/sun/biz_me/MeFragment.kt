package com.sun.biz_me

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.sun.biz_me.databinding.MeFragmentMeBinding
import com.sun.export_biz_msg.MsgServiceUtil
import com.sun.module_common.BaseFragment
import com.sun.module_common.RouterPath

/**
 * @author sunxianglei
 * @date 2021/2/24
 * @desc
 */
@Route(path = RouterPath.ME_FRAGMENT)
class MeFragment: BaseFragment() {
    private lateinit var binding: MeFragmentMeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MeFragmentMeBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init() {
        binding.btnMsg.setOnClickListener {
            binding.tvMe.text = "count from msg: ${MsgServiceUtil.getMsgCount()}"
        }
    }
}