package com.sun.modularlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.sun.modularlearning.databinding.ActivityMainBinding
import com.sun.module_common.RouterPath
import com.sun.module_util.log.MLog

@Route(path = RouterPath.APP_MAIN)
class MainActivity : AppCompatActivity() {
    @Autowired
    @JvmField
    var key: String = ""
    private lateinit var binding: ActivityMainBinding
    private val titles = arrayOf("首页", "消息", "我的")
    private val fragments: MutableList<Fragment> = mutableListOf()
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        init()
    }

    private fun init() {
        getFragments()
        for (title in titles) {
            binding.tbMain.addTab(binding.tbMain.newTab())
        }
        binding.tbMain.setupWithViewPager(binding.vpMain, true)
        binding.tbMain.addOnTabSelectedListener(MyTabChangeListener(binding.vpMain))
        binding.vpMain.adapter = MyPageAdapter(fragments, supportFragmentManager)
        binding.vpMain.offscreenPageLimit = 2
        for (i in titles.indices) {
            binding.tbMain.getTabAt(i)?.text = titles[i]
        }
    }

    private fun getFragments() {
        val homeFragment = ARouter.getInstance().build(RouterPath.HOME_FRAGMENT).navigation() as Fragment
        val msgFragment = ARouter.getInstance().build(RouterPath.MSG_FRAGMENT).navigation() as Fragment
        val meFragment = ARouter.getInstance().build(RouterPath.ME_FRAGMENT).navigation() as Fragment
        fragments.add(homeFragment)
        fragments.add(msgFragment)
        fragments.add(meFragment)
    }

    private class MyPageAdapter(val fragments: List<Fragment>, fm: FragmentManager): FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
    }

    private class MyTabChangeListener(val viewPager: ViewPager): TabLayout.OnTabSelectedListener {
        override fun onTabReselected(p0: TabLayout.Tab?) {
        }

        override fun onTabUnselected(p0: TabLayout.Tab?) {
        }

        override fun onTabSelected(p0: TabLayout.Tab?) {
            p0?.let {
                viewPager.currentItem = it.position
            }
        }

    }
}