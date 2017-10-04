package com.dan41k.conductorsample.ui.common.activity

import android.app.Activity
import com.dan41k.conductorsample.App

val Activity.app: App
    get() = application as App