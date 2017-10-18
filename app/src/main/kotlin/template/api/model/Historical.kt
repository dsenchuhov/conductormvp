package template.api.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Historical(@SerializedName("bpi") val bpi: Map<Date, Double>)