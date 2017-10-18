package template.ui.detail

import nucleus5.factory.RequiresPresenter
import template.R
import template.ui.common.annotation.Layout
import template.ui.common.mvp.controller.NucleusController
import template.ui.main.MainPresenter

@Layout(R.layout.controller_detail)
@RequiresPresenter(MainPresenter::class)
class DetailController : NucleusController<DetailPresenter>(), DetailPresenter.View