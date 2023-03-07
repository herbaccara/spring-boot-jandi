package herbaccara.jandi

import com.fasterxml.jackson.databind.JsonNode
import herbaccara.boot.autoconfigure.jandi.JandiProperties
import herbaccara.jandi.model.JandiMessage
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject

class DefaultJandiService(
    private val restTemplate: RestTemplate,
    private val properties: JandiProperties
) : JandiService {

    override fun send(message: JandiMessage): JsonNode {
        val defaultWebhookUrl = properties.defaultWebhookUrl
        if (defaultWebhookUrl.isNullOrBlank()) throw RuntimeException("webhookUrl must not be empty")

        return send(defaultWebhookUrl, message)
    }

    override fun send(webhookUrl: String, message: JandiMessage): JsonNode {
        val headers = HttpHeaders().apply {
            add("accept", "application/vnd.tosslab.jandi-v2+json")
            contentType = MediaType.APPLICATION_JSON
        }

        val httpEntity = HttpEntity(message, headers)
        return restTemplate.postForObject(webhookUrl, httpEntity)
    }
}
