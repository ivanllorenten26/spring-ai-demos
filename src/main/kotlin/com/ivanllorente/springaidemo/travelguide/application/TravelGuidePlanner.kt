package com.ivanllorente.springaidemo.travelguide.application

import com.ivanllorente.springaidemo.travelguide.domain.interfaces.TravelGuideAiService

class TravelGuidePlanner(
    private val aiService: TravelGuideAiService
) {

    fun invoke(city: String, month: String, budget: String): String {
        val response = aiService
            .getPlan(city, month, budget)
        // Simulate a call to an external service
        return "Travel Guide for: $city in $month with a budget of $budget \n $response"
    }
}