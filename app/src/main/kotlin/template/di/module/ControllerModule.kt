package template.di.module

import com.bluelinelabs.conductor.Controller
import dagger.Module
import template.di.scopes.ForController

@Module
@ForController
class ControllerModule(private val controller: Controller)