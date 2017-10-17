package template.ui

import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.RouterTransaction
import kotlinx.android.synthetic.main.activity_main.*
import template.R
import template.ui.common.activity.BaseActivity
import template.ui.common.annotation.Layout
import template.ui.main.MainController

@Layout(R.layout.activity_main)
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!router.hasRootController()) router.pushController(RouterTransaction.with(MainController()))
    }

    override fun container(): ViewGroup = container
}