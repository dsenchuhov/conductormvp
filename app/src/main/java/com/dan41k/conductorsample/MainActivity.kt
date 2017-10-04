package com.dan41k.conductorsample

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.w("MainActivity", router.toString())
    }

    override fun layout() = R.layout.activity_main

    override fun container(): ViewGroup = container
}