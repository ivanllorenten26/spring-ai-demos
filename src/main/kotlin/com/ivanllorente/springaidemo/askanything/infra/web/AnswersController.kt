package com.ivanllorente.springaidemo.askanything.infra.web

import com.ivanllorente.springaidemo.askanything.application.QuestionAnswerer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ask-anything")
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