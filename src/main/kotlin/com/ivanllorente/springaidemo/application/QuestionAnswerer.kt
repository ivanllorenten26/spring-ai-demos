package com.ivanllorente.springaidemo.application

import com.ivanllorente.springaidemo.domain.interfaces.AiChatService

class QuestionAnswerer(
    private val client: AiChatService
) {
    fun invoke(question: String): String {
        val response = client
            .response(question)
        // Simulate a call to an external service
        return "Answer to: $question \n $response"
    }
}