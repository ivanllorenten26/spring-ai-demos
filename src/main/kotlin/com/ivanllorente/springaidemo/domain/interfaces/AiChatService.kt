package com.ivanllorente.springaidemo.domain.interfaces

interface AiChatService {
    fun getResponse(question: String): String?
}