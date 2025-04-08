package com.ivanllorente.springaidemo.askanything.infra.ai

import com.ivanllorente.springaidemo.askanything.domain.interfaces.AskAiService
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.openai.OpenAiChatOptions
import org.springframework.stereotype.Service

@Service
class OpenAiAskAiService(
    private val chatClient: ChatClient
): AskAiService {


    override fun getResponse(question: String): String? {

        //val response = chatClient.prompt(question)
        val options = OpenAiChatOptions()
        options.model = "gpt-3.5-turbo"
        options.temperature = 0.7
        options.maxTokens = 1000
        options.topP = 1.0
        options.frequencyPenalty = 0.0
        options.presencePenalty = 0.0
        options.stop = listOf("\n", "Human:", "AI:")
        options.n = 1

        val response = chatClient.prompt(
            Prompt(
                question,
                options
            )
        )
        return response.call().chatResponse()?.results?.first()?.output?.text
    }
}