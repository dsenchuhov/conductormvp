package template.api.model

import com.google.gson.annotations.SerializedName

data class Time(
        @SerializedName("updated") val updated: String,
        @SerializedName("updatedISO") val updatedISO: String,
        @SerializedName("updateduk") val updateduk: String
) {
    override fun toString(): String {
        return "Time(updated='$updated', updatedISO='$updatedISO', updateduk='$updateduk')"
    }
}