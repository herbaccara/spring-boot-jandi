package herbaccara.jandi

import com.fasterxml.jackson.databind.JsonNode
import herbaccara.jandi.model.JandiMessage

interface JandiService {

    fun send(message: JandiMessage): JsonNode

    fun send(webhookUrl: String, message: JandiMessage): JsonNode
}
