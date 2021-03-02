package com.sun.biz_msg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.sun.biz_msg.databinding.MsgFragmentMsgBinding
import com.sun.module_common.BaseFragment
import com.sun.module_common.RouterPath

/**
 * @author sunxianglei
 * @date 2021/2/24
 * @desc
 */
@Route(path = RouterPath.MSG_FRAGMENT)
class MsgFragment: BaseFragment() {
    private lateinit var binding: MsgFragmentMsgBinding
    private val listener = object : MsgCount.ICountListener {
        override fun onCountChange(count: Int) {
            binding.tvMsg.text = "count from home: $count"
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MsgFragmentMsgBinding.inflate(inflater)
        init()
        return binding.root
    }

    private fun init(){
        MsgCount.instance.setCountListener(listener)
    }

    override fun onDestroy() {
        MsgCount.instance.removeCountListener(listener)
        super.onDestroy()
    }
}