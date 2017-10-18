package template.ui.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nucleus5.presenter.RxPresenter
import template.api.Api
import template.ui.main.cell.MainModel
import javax.inject.Inject

class MainPresenter : RxPresenter<MainPresenter.View>() {

    @Inject lateinit var api: Api

    fun fetchHistory() {
        add(api.getHistoricalPrice()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { historical ->
                            view?.onHistoricalLoaded(
                                    historical.bpi.toList().asReversed()
                                            .map { MainModel(it.first, it.second) })
                        },
                        { throwable -> view?.onError(throwable) }
                ))
    }

    interface View {

        fun onHistoricalLoaded(historical: List<MainModel>)

        fun onError(throwable: Throwable)
    }
}