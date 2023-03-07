package herbaccara.boot.autoconfigure.jandi

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "jandi")
@ConstructorBinding
data class JandiProperties(
    val enabled: Boolean = true,
    val defaultWebhookUrl: String? = null,
    val webhook: Webhook = Webhook(true, DEFAULT_WEBHOOK_PATH)
) {
    companion object {
        const val DEFAULT_WEBHOOK_PATH = "/jandi/webhook"
    }

    data class Webhook(val enabled: Boolean, val path: String)
}
