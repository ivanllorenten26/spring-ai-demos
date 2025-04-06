package com.ivanllorente.springaidemo.infra.web

import com.ivanllorente.springaidemo.application.QuestionAnswerer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AnswersController (
    private val questionAnswerer: QuestionAnswerer
) {

    @GetMapping("/answers")
    fun getAnswers(): ResponseEntity<String> {
        return ResponseEntity.ok("answers")
    }

    @PostMapping("/answers")
    fun postAnswers(@RequestParam("question") question: String): ResponseEntity<String> {
        val answer = questionAnswerer.invoke(question)
        return ResponseEntity.ok(answer)
    }
}