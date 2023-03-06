package herbaccara.jandi.model

data class ConnectInfo @JvmOverloads constructor(
    val title: String,
    val description: String,
    val imageUrl: String? = null
)
