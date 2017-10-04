package com.dan41k.conductorsample

import android.app.Activity

val Activity.app: App
    get() = application as App