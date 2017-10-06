package com.dan41k.conductorsample.ui.main

import com.dan41k.conductorsample.ui.main.model.Item
import nucleus.presenter.Presenter

class MainPresenter: Presenter<MainPresenter.View>() {

    val data = arrayListOf(
                    Item("Test1", "TEST DATA 1"),
                    Item("Test2", "TEST DATA 2"),
                    Item("Test3", "TEST DATA 3"),
                    Item("Test4", "TEST DATA 4"),
                    Item("Test5", "TEST DATA 5"),
                    Item("Test6", "TEST DATA 6"),
                    Item("Test7", "TEST DATA 7")
            )

    override fun onTakeView(view: View?) {
        super.onTakeView(view)
        view?.updateMenuData(data)
    }

    interface View {

        fun updateMenuData(data: List<Item>)
    }
}