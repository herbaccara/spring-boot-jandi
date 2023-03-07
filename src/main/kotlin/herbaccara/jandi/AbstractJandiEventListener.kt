package herbaccara.jandi

import herbaccara.jandi.model.JandiEvent
import org.springframework.context.event.EventListener

abstract class AbstractJandiEventListener {

    @EventListener
    abstract fun onEvent(jandiEvent: JandiEvent)
}
