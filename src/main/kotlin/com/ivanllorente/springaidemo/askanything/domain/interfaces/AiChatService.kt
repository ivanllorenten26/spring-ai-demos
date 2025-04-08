package com.ivanllorente.springaidemo.askanything.domain.interfaces

interface AiChatService {
    fun getResponse(question: String): String?
}