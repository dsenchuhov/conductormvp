package template.ui.common

import io.erva.celladapter.CellAdapter
import io.erva.celladapter.select.SelectableCellAdapter
import io.erva.celladapter.select.mode.SelectionManager

fun cellAdapter(func: CellAdapter.() -> CellAdapter) = CellAdapter().let(func)

fun singleSelectionCellAdapter(selectionManager: SelectionManager,
                               func: SelectableCellAdapter.() -> CellAdapter) = SelectableCellAdapter(mutableSetOf(), selectionManager).let(func)