package com.dan41k.conductorsample.ui

import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.RouterTransaction
import com.dan41k.conductorsample.R
import com.dan41k.conductorsample.ui.common.activity.BaseActivity
import com.dan41k.conductorsample.ui.common.annotation.Layout
import com.dan41k.conductorsample.ui.masterDetail.MainController
import kotlinx.android.synthetic.main.activity_main.*

@Layout(R.layout.activity_main)
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!router.hasRootController()) router.pushController(RouterTransaction.with(MainController()))
    }

    override fun container(): ViewGroup = container
}