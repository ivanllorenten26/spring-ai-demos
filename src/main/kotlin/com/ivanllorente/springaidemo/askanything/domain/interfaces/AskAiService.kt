package com.ivanllorente.springaidemo.askanything.domain.interfaces

interface AskAiService {
    fun getResponse(question: String): String?
}