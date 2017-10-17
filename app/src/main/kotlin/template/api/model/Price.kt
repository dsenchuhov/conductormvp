package template.api.model

import com.google.gson.annotations.SerializedName

class Price(
        @SerializedName("time") val time: Time,
        @SerializedName("disclaimer") val updated: String,
        @SerializedName("chartName") val chartName: String,
        @SerializedName("bpi") val bpi: Bpi
) {

    override fun toString(): String {
        return "Price(time=$time, updated='$updated', chartName='$chartName', bpi=$bpi)"
    }

    public data class Time(
            @SerializedName("updated") val updated: String,
            @SerializedName("updatedISO") val updatedISO: String,
            @SerializedName("updateduk") val updateduk: String
    ) {
        override fun toString(): String {
            return "Time(updated='$updated', updatedISO='$updatedISO', updateduk='$updateduk')"
        }
    }

    public data class Bpi(
            @SerializedName("USD") val currencyUsd: Currency,
            @SerializedName("GBP") val currencyGbp: Currency,
            @SerializedName("EUR") val currencyEur: Currency,
            @SerializedName("UAH") val currencyUah: Currency
    ) {
        override fun toString(): String {
            return "Bpi(currencyUsd=$currencyUsd, currencyGbp=$currencyGbp, currencyEur=$currencyEur)"
        }
    }

    public data class Currency(
            @SerializedName("code") val code: String,
            @SerializedName("symbol") val symbol: String,
            @SerializedName("rate") val rate: String,
            @SerializedName("description") val description: String,
            @SerializedName("rate_float") val rateFloat: Double
    ) {
        override fun toString(): String {
            return "Currency(code='$code', symbol='$symbol', rate='$rate', description='$description', rateFloat=$rateFloat)"
        }
    }
}