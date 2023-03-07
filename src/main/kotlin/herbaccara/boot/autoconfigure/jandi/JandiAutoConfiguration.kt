package herbaccara.boot.autoconfigure.jandi

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import herbaccara.jandi.DefaultJandiService
import herbaccara.jandi.JandiService
import herbaccara.jandi.JandiWebhookController
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import java.util.*

@AutoConfiguration
@EnableConfigurationProperties(JandiProperties::class)
@ConditionalOnProperty(prefix = "jandi", value = ["enabled"], havingValue = "true")
class JandiAutoConfiguration {

    @AutoConfiguration
    @ConditionalOnProperty(prefix = "jandi.webhook", value = ["enabled"], havingValue = "true")
    class JandiWebMvcConfigurer {

        @Bean
        @ConditionalOnMissingBean
        fun jandiWebhookController(applicationEventPublisher: ApplicationEventPublisher): JandiWebhookController {
            return JandiWebhookController(applicationEventPublisher)
        }
    }

    @Bean
    @ConditionalOnMissingBean
    fun objectMapper(): ObjectMapper {
        return jacksonObjectMapper().apply {
            findAndRegisterModules()
        }
    }

    @Bean
    @ConditionalOnMissingBean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    @ConditionalOnMissingBean
    fun jandiService(
        restTemplate: RestTemplate,
        properties: JandiProperties
    ): JandiService {
        return DefaultJandiService(restTemplate, properties)
    }
}
