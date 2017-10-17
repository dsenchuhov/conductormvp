package template.ui.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nucleus5.presenter.RxPresenter
import template.api.Api
import template.api.model.Price
import javax.inject.Inject

class MainPresenter : RxPresenter<MainPresenter.View>() {

    @Inject lateinit var api: Api

    override fun onTakeView(view: View?) {
        super.onTakeView(view)
    }

    fun getCurrency() {
        api.getCurrentPrice("UAH")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { currencyPrice -> view?.onCurrency(currencyPrice) },
                        { _ -> view?.onError() }
                )
    }

    interface View {

        fun onCurrency(currencyPrice: Price)

        fun onError()
    }
}