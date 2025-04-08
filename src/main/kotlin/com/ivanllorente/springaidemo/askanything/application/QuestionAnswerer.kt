package com.ivanllorente.springaidemo.askanything.application

import com.ivanllorente.springaidemo.askanything.domain.interfaces.AskAiService

class QuestionAnswerer(
    private val chatService: AskAiService
) {
    fun invoke(question: String): String {
        val response = chatService
            .getResponse(question)
        // Simulate a call to an external service
        return "Answer to: $question \n $response"
    }
}