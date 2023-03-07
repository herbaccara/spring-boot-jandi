package herbaccara.jandi.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test

class JandiEventTest {

    @Test
    fun test() {
        val objectMapper = jacksonObjectMapper().apply {
            findAndRegisterModules()
        }

        val json = """
            {
                "token" : "YE1ronbbuoZkq7h3J5KMI4Tn",
                "teamName" : "Toss Lab, Inc.",
                "roomName" : "Bulletin Board",
                "writer" : {
                    "id" : "20135452",
                    "name" : "Kevin",
                    "email" : "kevin@tosslab.com",
                    "phoneNumber" : "2061234567"
                },
                "text" : "/weather How is the weather in New York tomorrow?",
                "data" : "How is the weather in New York tomorrow?",
                "keyword" : "weather",
                "createdAt" : "2017-05-15T11:34:11.266Z",
                "platform" : "web",
                "ip" : "12.345.67.89"
            }
        """.trimIndent()

        val jandiEvent: JandiEvent = objectMapper.readValue(json)

        println()
    }
}
