package template.ui.main

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import io.erva.celladapter.Cell
import io.erva.celladapter.CellAdapter
import kotlinx.android.synthetic.main.controller_main.view.*
import nucleus5.factory.RequiresPresenter
import template.R
import template.ui.common.annotation.Layout
import template.ui.common.mvp.controller.NucleusController
import template.ui.main.cell.MainCell
import template.ui.main.cell.MainModel

@Layout(R.layout.controller_main)
@RequiresPresenter(MainPresenter::class)
class MainController : NucleusController<MainPresenter>(), MainPresenter.View {

    private var mainAdapter: CellAdapter = CellAdapter().let {
        it.cell(MainCell::class) {
            item(MainModel::class)
            listener(object : Cell.Listener<MainModel> {
                override fun onCellClicked(item: MainModel) {
                }
            })
        }
    }

    override fun onViewCreated(view: View) {
        super.onViewCreated(view)
        with(view.recyclerView) {
            layoutManager = LinearLayoutManager(view.context)
            addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.HORIZONTAL))
            adapter = mainAdapter
        }
        presenter.fetchHistory()
    }

    override fun onHistoricalLoaded(mainModels: List<MainModel>) {
        mainAdapter.clear()
        mainAdapter.addItems(mainModels)
        mainAdapter.notifyDataSetChanged()
    }

    override fun onError() {
    }
}