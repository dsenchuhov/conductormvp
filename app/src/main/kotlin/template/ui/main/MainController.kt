package template.ui.main

import android.view.View
import kotlinx.android.synthetic.main.controller_main.view.*
import nucleus5.factory.RequiresPresenter
import template.R
import template.api.model.Price
import template.ui.common.annotation.Layout
import template.ui.common.mvp.controller.NucleusController

@Layout(R.layout.controller_main)
@RequiresPresenter(MainPresenter::class)
class MainController : NucleusController<MainPresenter>(), MainPresenter.View {

    override fun onCurrency(price: Price) {
        view?.price?.text = "1 BTC = ${"%.2f".format(price.bpi.currencyUah.rateFloat)} UAH"
    }

    override fun onError() {
        view?.price?.text = "Error"
    }

    override fun onViewCreated(view: View) {
        super.onViewCreated(view)
        presenter.getCurrency()
    }
}