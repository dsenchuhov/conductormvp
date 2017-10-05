package com.dan41k.conductorsample.ui.masterDetail

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.dan41k.conductorsample.R
import com.dan41k.conductorsample.ui.common.annotation.Layout
import com.dan41k.conductorsample.ui.common.mvp.controller.NucleusController
import com.dan41k.conductorsample.ui.common.singleSelectionCellAdapter
import com.dan41k.conductorsample.ui.masterDetail.cell.ItemCell
import com.dan41k.conductorsample.ui.masterDetail.model.Item
import io.erva.celladapter.Cell
import io.erva.celladapter.select.mode.SingleSelectionManager
import kotlinx.android.synthetic.main.controller_main.view.*
import nucleus.factory.RequiresPresenter

@Layout(R.layout.controller_main)
@RequiresPresenter(MainPresenter::class)
class MainController : NucleusController<MainPresenter>() {

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

    private fun onItemSelected(item: Item) {
        //TODO go to details screen
    }
}