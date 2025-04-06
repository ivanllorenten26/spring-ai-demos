package com.ivanllorente.springaidemo.domain.interfaces

interface AiChatService {
    fun response(question: String): String?
}