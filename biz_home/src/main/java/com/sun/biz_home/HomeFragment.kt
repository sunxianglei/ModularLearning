package com.sun.biz_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.sun.biz_home.databinding.HomeFragmentHomeBinding
import com.sun.export_biz_msg.MsgServiceUtil
import com.sun.module_common.BaseFragment
import com.sun.module_common.RouterPath

/**
 * @author sunxianglei
 * @date 2021/2/22
 * @desc
 */
@Route(path = RouterPath.HOME_FRAGMENT)
class HomeFragment: BaseFragment() {

    private lateinit var binding: HomeFragmentHomeBinding
    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentHomeBinding.inflate(inflater)
        init()
        return binding.root
    }
    private fun init() {
        binding.btnHome.setOnClickListener {
            MsgServiceUtil.onCountFromHome(++count)
        }
    }

}