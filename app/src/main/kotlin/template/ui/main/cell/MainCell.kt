package template.ui.main.cell

import android.view.View
import io.erva.celladapter.Cell
import io.erva.celladapter.Layout
import io.erva.celladapter.select.SelectableCell
import kotlinx.android.synthetic.main.cell_main.view.*
import template.R
import java.text.SimpleDateFormat

@Layout(R.layout.cell_main)
class MainCell(view: View) : SelectableCell<MainModel, Cell.Listener<MainModel>>(view) {

    override fun bindView() {
        view.title.text = "${SimpleDateFormat("dd.MM.yyyy").format(item().date)}: ${"%.2f".format(item().price)} USD"
    }
}