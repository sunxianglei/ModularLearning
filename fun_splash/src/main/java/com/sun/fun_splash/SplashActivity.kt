package com.sun.fun_splash

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.alibaba.android.arouter.launcher.ARouter
import com.sun.module_common.RouterPath

/**
 * @author sunxianglei
 * @date 2021/2/23
 * @desc 启动页
 */
class SplashActivity: AppCompatActivity() {

    private val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA)
    companion object {
        const val PERMISSION_CODE = 0x0001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spash_activity_splash)
        initPermission()
    }

    private fun initPermission() {
        ActivityCompat.requestPermissions(this,
            permissions,
            PERMISSION_CODE)
    }

    private fun goMainActivity() {
        ARouter.getInstance().build(RouterPath.APP_MAIN)
            .withString("test", "value")
            .navigation()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == PERMISSION_CODE) {
            if(grantResults.isNotEmpty()
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                goMainActivity()
            }else {
                if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "向您解释，需要存储权限才能使用此app", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "告知您，您永久禁用了权限，需要去设置内手动开启", Toast.LENGTH_SHORT).show()
                }
                Handler(Looper.getMainLooper()).postDelayed({ finish() }, 1000)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}