package com.dan41k.conductorsample.ui.masterDetail.cell

import android.view.View
import com.dan41k.conductorsample.R
import com.dan41k.conductorsample.ui.masterDetail.model.Item
import io.erva.celladapter.Cell
import io.erva.celladapter.Layout
import io.erva.celladapter.select.SelectableCell

@Layout(R.layout.cell_main)
class ItemCell(view: View): SelectableCell<Item, Cell.Listener<Item>>(view) {

    override fun bindView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}