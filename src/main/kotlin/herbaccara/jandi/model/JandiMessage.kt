package herbaccara.jandi.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class JandiMessage @JvmOverloads constructor(
    val body: String,
    val connectColor: String,
    @field:JsonProperty("connectInfo")
    val connectInfos: List<ConnectInfo> = emptyList(),
    val email: String? = null
)
