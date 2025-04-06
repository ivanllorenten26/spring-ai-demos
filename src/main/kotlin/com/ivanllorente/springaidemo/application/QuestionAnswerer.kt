package com.ivanllorente.springaidemo.application

import com.ivanllorente.springaidemo.domain.interfaces.AiChatService

class QuestionAnswerer(
    private val chatService: AiChatService
) {
    fun invoke(question: String): String {
        val response = chatService
            .getResponse(question)
        // Simulate a call to an external service
        return "Answer to: $question \n $response"
    }
}