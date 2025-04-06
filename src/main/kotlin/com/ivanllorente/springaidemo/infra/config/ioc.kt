package com.ivanllorente.springaidemo.infra.config

import com.ivanllorente.springaidemo.application.QuestionAnswerer
import com.ivanllorente.springaidemo.infra.ai.OpenAiChatService
import org.springframework.ai.chat.client.ChatClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ioc (
    private val chatBuilder: ChatClient.Builder
){

    @Bean
    fun chatClient(): ChatClient {
        val chatClient = chatBuilder.build()
        return chatClient
    }

     @Bean
     fun questionAnswerer(): QuestionAnswerer {
         return QuestionAnswerer(
                chatService = OpenAiChatService(chatClient())
         )
     }
}