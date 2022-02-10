package com.adevinta.springbootbasics.infrastructure.controller

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(HelloWorldController::class)
class HelloWorldControllerTest {

  @Autowired
  private lateinit var mvc: MockMvc

  @Test
  fun `should say hello`() {
    mvc.perform(MockMvcRequestBuilders.get("/hello"))
      .andExpect(MockMvcResultMatchers.status().isOk)
      .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Hello world")))
  }
}
