package com.jama.domain.usecases

interface BaseUseCase<in Parameter, out Result> {
    suspend operator fun invoke(param: Parameter): Result
}