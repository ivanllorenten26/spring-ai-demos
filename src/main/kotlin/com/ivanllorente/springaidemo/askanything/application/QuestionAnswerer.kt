package com.ivanllorente.springaidemo.askanything.application

import com.ivanllorente.springaidemo.askanything.domain.interfaces.AiChatService

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