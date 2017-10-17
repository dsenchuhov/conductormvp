package template.ui.main

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import io.erva.celladapter.select.mode.SingleSelectionManager
import kotlinx.android.synthetic.main.controller_main.view.*
import nucleus.factory.RequiresPresenter
import template.R
import template.ui.common.annotation.Layout
import template.ui.common.mvp.controller.NucleusController
import template.ui.common.singleSelectionCellAdapter
import template.ui.main.cell.ItemCell
import template.ui.main.model.Item

@Layout(R.layout.controller_main)
@RequiresPresenter(MainPresenter::class)
class MainController : NucleusController<MainPresenter>(), MainPresenter.View {

    private val mainAdapter by lazy {
        singleSelectionCellAdapter(SingleSelectionManager()) {
            cell(ItemCell::class) {
                item(Item::class)
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
}