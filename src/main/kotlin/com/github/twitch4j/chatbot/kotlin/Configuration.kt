package com.github.twitch4j.chatbot.kotlin

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Configuration(
    val debug: Boolean = false,
    val bot: Map<String, String> = mapOf(),
    val api: Map<String, String> = mapOf(),
    val credentials: Map<String, String> = mapOf(),
    val channels: List<String> = listOf()
)
