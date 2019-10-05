package com.shuyun.egami.module.apod

import android.os.Bundle
import com.shuyun.egami.R
import com.shuyun.egami.module.base.BaseActivity
import com.shuyun.egami.utils.ActivityUtil

class ApodActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.apod_activity)

        val fragment = ApodFragment.newInstance()
        ActivityUtil.addFragment2Activity(supportFragmentManager, fragment, R.id.flContent)

        add2LifeCycle(ApodPresenter(this, fragment))

    }

}