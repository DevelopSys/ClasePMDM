package com.example.repaso.model

data class Pregunta (
    val type: String? = null,
    val difficulty: String? = null,
    val category: String? = null,
    val question: String? = null,
    val correctAnswer: String? = null,
    val incorrectAnswers: List<String>? = null
)
