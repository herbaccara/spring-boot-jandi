package herbaccara.jandi

import com.fasterxml.jackson.databind.JsonNode
import herbaccara.jandi.model.JandiMessage
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject

class JandiTemplate(private val restTemplate: RestTemplate) {

    fun send(webhookUrl: String, message: JandiMessage) {
        val headers = HttpHeaders().apply {
            add("accept", "application/vnd.tosslab.jandi-v2+json")
            contentType = MediaType.APPLICATION_JSON
        }

        val httpEntity = HttpEntity(message, headers)
        val json = restTemplate.postForObject<JsonNode>(webhookUrl, httpEntity)
    }
}
