package herbaccara.jandi

import herbaccara.jandi.model.ConnectInfo
import herbaccara.jandi.model.JandiMessage
import org.junit.jupiter.api.Test

class DefaultJandiServiceTest {

    @Test
    fun test() {
        val jandiService =
            DefaultJandiService("")

        jandiService.send(
            JandiMessage(
                "[[PizzaHouse]](http://url_to_text) You have a new Pizza order.",
                "#FAC11B",
                listOf(
                    ConnectInfo("Topping", "Pepperoni"),
                    ConnectInfo("Location", "Empire State Building, 5th Ave, New York", "http://url_to_text")
                )
            )
        )
    }
}
