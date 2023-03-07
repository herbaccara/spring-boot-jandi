package herbaccara.jandi.model

data class JandiEvent(
    val token: String,
    val teamName: String,
    val roomName: String,
    val writer: Writer,
    val text: String,
    val data: String,
    val keyword: String,
//    @field:JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//    val createdAt: LocalDateTime,
    val createdAt: String,
    val platform: String,
    val ip: String
) {
    data class Writer(
        val id: String,
        val name: String,
        val email: String,
        val phoneNumber: String
    )
}
