package com.ivanllorente.springaidemo.travelguide.domain.interfaces

interface TravelGuideAiService {
    fun getPlan(city: String, month: String, budget: String): String?
}