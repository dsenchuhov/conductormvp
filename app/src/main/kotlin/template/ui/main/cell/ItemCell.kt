package template.ui.main.cell

import android.view.View
import io.erva.celladapter.Cell
import io.erva.celladapter.Layout
import io.erva.celladapter.select.SelectableCell
import kotlinx.android.synthetic.main.cell_main.view.*
import template.R
import template.ui.main.model.Item

@Layout(R.layout.cell_main)
class ItemCell(view: View): SelectableCell<Item, Cell.Listener<Item>>(view) {

    override fun bindView() {
        view.title.text = item().title
    }
}