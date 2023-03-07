package herbaccara.boot.autoconfigure.jandi

import org.springframework.context.annotation.Import
import java.lang.annotation.*

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(JandiAutoConfiguration::class)
annotation class EnableJandi
