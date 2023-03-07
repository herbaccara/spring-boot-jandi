package herbaccara.jandi

import herbaccara.boot.autoconfigure.jandi.JandiAutoConfiguration
import herbaccara.jandi.model.ConnectInfo
import herbaccara.jandi.model.JandiMessage
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest(
    classes = [
        JandiAutoConfiguration::class
    ]
)
@TestPropertySource(locations = ["classpath:application.yml"])
class JandiServiceTest {

    @Autowired
    lateinit var jandiService: JandiService

    @Test
    fun send() {
        val response = jandiService.send(
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
