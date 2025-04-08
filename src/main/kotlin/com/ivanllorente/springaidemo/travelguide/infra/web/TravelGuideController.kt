package com.ivanllorente.springaidemo.travelguide.infra.web

import com.ivanllorente.springaidemo.travelguide.application.TravelGuidePlanner
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/travel-guide")
class TravelGuideController (
    private val travelGuidePlanner: TravelGuidePlanner
) {
    @GetMapping("/show")
    fun showTravelGuide(): String {
        return "Welcome to the Travel Guide!"
    }

    @PostMapping("/")
    fun postTravelGuide(
        @RequestParam("city") city: String,
        @RequestParam("month") month: String,
        @RequestParam("budget") budget: String,
    ): ResponseEntity<String> {
        val answer = travelGuidePlanner.invoke(city, month, budget)
        return ResponseEntity.ok(answer)
    }
}