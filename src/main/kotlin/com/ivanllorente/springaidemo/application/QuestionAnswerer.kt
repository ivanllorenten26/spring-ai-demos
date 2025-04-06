package com.ivanllorente.springaidemo.application

class QuestionAnswerer {
    fun invoke(question: String): String {
        // Simulate a call to an external service
        return "Answer to: $question"
    }
}