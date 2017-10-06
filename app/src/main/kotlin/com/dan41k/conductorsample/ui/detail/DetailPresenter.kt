package com.dan41k.conductorsample.ui.detail

import com.dan41k.conductorsample.ui.main.model.Item
import nucleus.presenter.Presenter

class DetailPresenter: Presenter<DetailPresenter.View>() {

    private lateinit var data: Item

    fun setData(item: Item) {
        this.data = item
    }

    interface View
}