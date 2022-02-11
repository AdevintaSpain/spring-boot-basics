package com.adevinta.springbootbasics.infrastructure.configuration

import com.adevinta.springbootbasics.domain.Bar
import com.adevinta.springbootbasics.domain.Foo
import com.adevinta.springbootbasics.domain.Tik
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import java.time.Duration

@Configuration
class ApplicationConfiguration {

  @Bean
  fun unTik(bars: List<Bar>) = Tik(bars)

  @Bean
  fun unFoo(bar: Bar) = Foo(bar)

  @Bean(name = ["OtroBar"])
  @Primary
  @Profile("!pre")
  fun otroBar() = Bar(14, Duration.ofMinutes(5))

  @Bean(name = ["OtroBar"])
  @Primary
  @Profile("pre")
  fun otroBarForPre() = Bar(15, Duration.ofMinutes(6))

  @Bean(name = ["UnBar"])
  fun unBar(
    @Value("\${bar.stock:91}") elStock: Int,
    @Value("\${bar.timeout}") elTimeout: Duration
  ) = Bar(elStock, elTimeout)
}
