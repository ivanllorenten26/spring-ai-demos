package com.ivanllorente.springaidemo.infra.ai

import com.ivanllorente.springaidemo.domain.interfaces.AiChatService
import org.springframework.ai.chat.client.ChatClient
import org.springframework.stereotype.Service

@Service
class OpenAiChatService(
    private val chatClient: ChatClient
): AiChatService {


    override fun response(question: String): String? {

        val response = chatClient.prompt(question)
        return response.call().chatResponse()?.results?.first()?.output?.text
    }
}