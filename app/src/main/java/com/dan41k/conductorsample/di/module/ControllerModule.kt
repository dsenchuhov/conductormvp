package com.dan41k.conductorsample.di.module

import com.bluelinelabs.conductor.Controller
import com.dan41k.conductorsample.di.scopes.ForController
import dagger.Module

@Module @ForController class ControllerModule(private val controller: Controller)