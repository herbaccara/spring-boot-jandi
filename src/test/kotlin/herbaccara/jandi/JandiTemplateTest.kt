package herbaccara.jandi

import herbaccara.jandi.model.ConnectInfo
import herbaccara.jandi.model.JandiMessage
import org.junit.jupiter.api.Test
import org.springframework.web.client.RestTemplate

class JandiTemplateTest {

    @Test
    fun send() {
        val endpoint = "https://wh.jandi.com/connect-api/webhook/29568596/227e10c874be644d1daa41e938b6d1f1"
        val jandiTemplate = JandiTemplate(RestTemplate())
        val response = jandiTemplate.send(
            endpoint,
            JandiMessage(
                "[[PizzaHouse]](http://url_to_text) You have a new Pizza order.",
                "#FAC11B",
                listOf(
                    ConnectInfo("Topping", "Pepperoni"),
                    ConnectInfo("Location", "Empire State Building, 5th Ave, New York", "http://url_to_text")
                )
            )
        )
        println(response)
    }
}
