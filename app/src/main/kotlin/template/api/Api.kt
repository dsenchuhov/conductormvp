package template.api

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import template.api.model.Historical
import template.api.model.Price

/**
 * https://www.coindesk.com/api/
 * https://api.coindesk.com/v1/bpi/supported-currencies.json
 */
interface Api {

    @GET("currentprice.json")
    fun getCurrentPrice(): Flowable<Price>

    @GET("currentprice/{code}.json")
    fun getCurrentPrice(@Path("code") code: String): Flowable<Price>

    @GET("historical/close.json")
    fun getHistoricalPrice(): Flowable<Historical>
}