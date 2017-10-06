package com.dan41k.conductorsample.ui.main

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.dan41k.conductorsample.R
import com.dan41k.conductorsample.ui.common.activity.isLandscapeOrientation
import com.dan41k.conductorsample.ui.common.activity.isTablet
import com.dan41k.conductorsample.ui.common.annotation.Layout
import com.dan41k.conductorsample.ui.common.mvp.controller.NucleusController
import com.dan41k.conductorsample.ui.common.singleSelectionCellAdapter
import com.dan41k.conductorsample.ui.detail.DetailController
import com.dan41k.conductorsample.ui.main.cell.ItemCell
import com.dan41k.conductorsample.ui.main.model.Item
import io.erva.celladapter.Cell
import io.erva.celladapter.select.mode.SingleSelectionManager
import kotlinx.android.synthetic.main.controller_main.view.*
import nucleus.factory.RequiresPresenter

@Layout(R.layout.controller_main)
@RequiresPresenter(MainPresenter::class)
class MainController : NucleusController<MainPresenter>(), MainPresenter.View {

    private val mainAdapter by lazy {
        singleSelectionCellAdapter(SingleSelectionManager()) {
            cell(ItemCell::class) {
                item(Item::class)

                listener(object : Cell.Listener<Item> {
                    override fun onCellClicked(item: Item) {
                        onItemSelected(item)
                    }
                })
            }
        }
    }

    override fun onViewCreated(view: View) {
        super.onViewCreated(view)
        with(view.recyclerView) {
            layoutManager = LinearLayoutManager(view.context)
            addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.HORIZONTAL))
            adapter = mainAdapter
        }
    }

    override fun updateMenuData(data: List<Item>) {
        if (mainAdapter.items.isEmpty()) mainAdapter.addItems(data)
    }

    private fun onItemSelected(item: Item) {
        if (activity!!.isTablet() && activity!!.isLandscapeOrientation()) {
            getChildRouter(view!!.detailContainer).setRoot(RouterTransaction.with(DetailController(item))
                    .pushChangeHandler(FadeChangeHandler())
                    .popChangeHandler(FadeChangeHandler()))
        } else {
            router.pushController(RouterTransaction.with(DetailController(item))
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler()))
        }
    }
}