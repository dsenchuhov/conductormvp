package template.ui.main

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import io.erva.celladapter.Cell
import io.erva.celladapter.CellAdapter
import kotlinx.android.synthetic.main.controller_main.view.*
import nucleus5.factory.RequiresPresenter
import template.R
import template.ui.common.annotation.Layout
import template.ui.common.mvp.controller.NucleusController
import template.ui.detail.DetailController
import template.ui.main.cell.MainCell
import template.ui.main.cell.MainModel
import timber.log.Timber

@Layout(R.layout.controller_main)
@RequiresPresenter(MainPresenter::class)
class MainController : NucleusController<MainPresenter>(), MainPresenter.View {

    private var mainAdapter: CellAdapter = CellAdapter().let {
        it.cell(MainCell::class) {
            item(MainModel::class)
            listener(object : Cell.Listener<MainModel> {
                override fun onCellClicked(item: MainModel) {
                    goToDetails(item)
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

    override fun onError(throwable: Throwable) {
        Timber.d(throwable)
        Toast.makeText(activity, throwable.message, Toast.LENGTH_LONG).show()
    }

    private fun goToDetails(mainModel: MainModel) {
        val toController = DetailController()
        router.pushController(RouterTransaction.with(toController)
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler()))
    }
}