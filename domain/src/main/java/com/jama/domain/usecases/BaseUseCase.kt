package com.jama.domain.usecases

interface BaseUseCase<out Result> {
    suspend operator fun invoke(): Result
}