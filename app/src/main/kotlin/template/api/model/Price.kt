package template.api.model

import com.google.gson.annotations.SerializedName

class Price(
        @SerializedName("time") val time: Time,
        @SerializedName("disclaimer") val updated: String,
        @SerializedName("chartName") val chartName: String,
        @SerializedName("bpi") val bpi: Map<String, Currency>
) {

    override fun toString(): String {
        return "Price(time=$time, updated='$updated', chartName='$chartName', bpi=$bpi)"
    }
}