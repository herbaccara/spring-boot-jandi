package herbaccara.jandi

import herbaccara.boot.autoconfigure.jandi.JandiProperties
import herbaccara.jandi.model.JandiEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${jandi.webhook.path:${JandiProperties.DEFAULT_WEBHOOK_PATH}}")
class JandiWebhookController(
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    @PostMapping
    fun onEvent(@RequestBody jandiEvent: JandiEvent) {
        applicationEventPublisher.publishEvent(jandiEvent)
    }
}
