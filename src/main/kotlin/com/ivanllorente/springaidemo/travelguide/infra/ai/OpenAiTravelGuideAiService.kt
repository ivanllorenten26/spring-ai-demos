package com.ivanllorente.springaidemo.travelguide.infra.ai

import com.ivanllorente.springaidemo.travelguide.domain.interfaces.TravelGuideAiService
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.ai.openai.OpenAiChatOptions
import org.springframework.stereotype.Service

@Service
class OpenAiTravelGuideAiService(
    private val chatClient: ChatClient
): TravelGuideAiService {


    override fun getPlan(city: String, month: String, budget: String): String? {


        //val response = chatClient.prompt(question)
        val options = OpenAiChatOptions()
        options.model = "gpt-3.5-turbo"
        options.maxTokens = 1000

        val templateBody = """
            You are a travel guide assistant. 
            Plan a trip to $city in $month with a budget of $budget.
            Provide a detailed itinerary including:
            1: places to visit
            2: activities
            3: and estimated costs.
        """.trimIndent()

        val placeholderMap = mapOf(
            "city" to city,
            "month" to month,
            "budget" to budget
        )

        val promptTemplate =  PromptTemplate(
            templateBody,
            placeholderMap
        ).create()

        val response = chatClient.prompt(promptTemplate).call()

        return response.chatResponse()?.results?.map {
            it.output?.text
        }?.joinToString("\n")
    }
}