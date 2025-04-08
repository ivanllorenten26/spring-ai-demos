package com.ivanllorente.springaidemo.shared.infra.config

import com.ivanllorente.springaidemo.askanything.application.QuestionAnswerer
import com.ivanllorente.springaidemo.askanything.infra.ai.OpenAiChatService
import com.ivanllorente.springaidemo.travelguide.application.TravelGuidePlanner
import com.ivanllorente.springaidemo.travelguide.infra.ai.OpenAiTravelGuideAiService
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor
import org.springframework.ai.chat.memory.InMemoryChatMemory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ioc (
    private val chatBuilder: ChatClient.Builder
){

    @Bean
    fun chatClient(): ChatClient {
        //val chatClient = chatBuilder.build()
        val chatClient = chatBuilder.defaultAdvisors(
            MessageChatMemoryAdvisor(
                InMemoryChatMemory()
            )
        ).build()
        return chatClient
    }

     @Bean
     fun questionAnswerer(): QuestionAnswerer {
         return QuestionAnswerer(
             chatService = OpenAiChatService(chatClient())
         )
     }

    @Bean
    fun travelGuidePlanner(): TravelGuidePlanner {
        return TravelGuidePlanner(
           aiService = OpenAiTravelGuideAiService(chatClient())
        )
    }
}