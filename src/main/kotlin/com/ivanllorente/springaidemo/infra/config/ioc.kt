package com.ivanllorente.springaidemo.infra.config

import com.ivanllorente.springaidemo.application.QuestionAnswerer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ioc {
    // Define your beans here
    // For example:
     @Bean
     fun questionAnswerer(): QuestionAnswerer {
         return QuestionAnswerer()
     }
}