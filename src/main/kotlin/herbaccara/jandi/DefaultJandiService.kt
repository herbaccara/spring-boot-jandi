package herbaccara.jandi

import com.fasterxml.jackson.databind.JsonNode
import herbaccara.jandi.model.JandiMessage
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject

class DefaultJandiService @JvmOverloads constructor(
    private val webhookUrl: String,
    private val restTemplate: RestTemplate = RestTemplate()
) : JandiService {

    override fun send(message: JandiMessage): JsonNode {
        return send(webhookUrl, message)
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
