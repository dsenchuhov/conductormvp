package com.dan41k.conductorsample.ui.detail

import android.os.Bundle
import android.view.View
import com.dan41k.conductorsample.R
import com.dan41k.conductorsample.ui.common.annotation.Layout
import com.dan41k.conductorsample.ui.common.mvp.controller.NucleusController
import com.dan41k.conductorsample.ui.main.model.Item
import kotlinx.android.synthetic.main.controller_detail.view.*
import nucleus.factory.RequiresPresenter

@Layout(R.layout.controller_detail)
@RequiresPresenter(DetailPresenter::class)
class DetailController: NucleusController<DetailPresenter>, DetailPresenter.View {

    constructor(item: Item) {
        args.putSerializable(ITEM, item)
    }

    constructor(bundle: Bundle): super(bundle)

    override fun onViewCreated(view: View) {
        super.onViewCreated(view)
        presenter.setData(args.getSerializable(ITEM) as Item)
        view.data.text = (args.getSerializable(ITEM) as Item).data
    }

    companion object {

        const val ITEM: String = "ITEM"
    }
}