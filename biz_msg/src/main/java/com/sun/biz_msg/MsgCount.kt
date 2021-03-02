package com.sun.biz_msg

/**
 * @author sunxianglei
 * @date 2021/2/25
 * @desc
 */

class MsgCount private constructor() {
    private var count = 0
    private val countListeners = mutableListOf<ICountListener>()
    companion object {
        // 双重校验锁
        val instance: MsgCount by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            MsgCount()
        }
    }

    fun getCount(): Int{
        return count
    }

    fun addCount(num: Int = 1) {
        this.count = num
        for(listener in countListeners) {
            listener.onCountChange(count)
        }
    }

    fun setCountListener(listener: ICountListener) {
        this.countListeners.add(listener);
    }

    fun removeCountListener(listener: ICountListener) {
        this.countListeners.remove(listener)
    }

    fun reset(){
        this.count = 0
        this.countListeners.clear()
    }

    interface ICountListener{
        fun onCountChange(count: Int)
    }
}