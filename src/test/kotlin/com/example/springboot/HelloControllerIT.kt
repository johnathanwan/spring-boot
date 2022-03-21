package com.example.springboot

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*
import org.springframework.boot.test.web.client.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIT(@Autowired val template: TestRestTemplate) {

    @Test
    fun getHello() {
        val response = template.getForEntity("/", String::class.java)
        assertThat(response.body).isEqualTo("Greetings from Spring Boot!")
    }

}