package com.adevinta.springbootbasics.infrastructure

import com.adevinta.springbootbasics.domain.Foo
import com.adevinta.springbootbasics.domain.Bar
import com.adevinta.springbootbasics.domain.Tik
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.time.Duration

@SpringBootTest
@ActiveProfiles("pre")
class ApplicationTest {

  companion object {

    @BeforeAll
    @JvmStatic
    fun beforeAll() {
      System.setProperty("bar.stock", "388")
    }
  }

  @Value("\${spring.application.name}")
  private lateinit var applicationName: String

  @Autowired
  private lateinit var tik: Tik

  @Autowired
  private lateinit var foo: Foo

  @Autowired
  @Qualifier("OtroBar")
  private lateinit var bar1: Bar

  @Autowired
  @Qualifier("UnBar")
  private lateinit var bar2: Bar

  @Test
  fun `should load context`() {
    assertThat(foo).isNotNull
    assertThat(foo.bar).isEqualTo(bar1)

    assertThat(tik).isNotNull
    assertThat(tik.bars)
      .containsExactlyInAnyOrder(bar1, bar2)

    assertThat(bar1).isNotNull
    assertThat(bar1.stock)
      .isEqualTo(15)
    assertThat(bar1.timeout)
      .isEqualTo(Duration.ofMinutes(6))

    assertThat(bar2).isNotNull
    assertThat(bar2.stock)
      .isEqualTo(388)
    assertThat(bar2.timeout)
      .isEqualTo(Duration.ofSeconds(53))
  }

  @Test
  fun `should load application name`() {
    assertThat(applicationName).isEqualTo("spring-boot-basics")
  }
}
