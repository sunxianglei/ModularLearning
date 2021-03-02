package com.sun.biz_home.debug

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.biz_home.HomeFragment
import com.sun.biz_home.R
import com.sun.biz_home.databinding.HomeActivityHomeBinding

/**
 * @author sunxianglei
 * @date 2021/2/22
 * @desc
 */
class HomeActivity: AppCompatActivity() {
    private lateinit var binding: HomeActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        init()
    }

    private fun init() {
        val homeFragment = HomeFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.fl_home, homeFragment)
        transaction.commit()
    }
}