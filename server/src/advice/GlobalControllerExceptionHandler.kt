package dev.hikari.oneforall.advice

import dev.hikari.oneforall.dto.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.support.WebExchangeBindException

@RestControllerAdvice
class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException::class)
    fun handle(e: IllegalArgumentException): ApiResponse<Unit> {
        println("捕获到了IllegalArgumentException")
        return ApiResponse(400, e.message ?: e.toString(), null)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WebExchangeBindException::class)
    fun handle(e: WebExchangeBindException): ApiResponse<Unit> {
        println("捕获到了WebExchangeBindException")
        return ApiResponse(
            400,
            e.bindingResult.allErrors.joinToString { "${it.objectName}: ${it.defaultMessage}" },
            null
        )
    }

    @ExceptionHandler(Exception::class)
    fun handle(e: Exception): ApiResponse<Unit> {
        println("捕获到了Exception")
//        when (e) {
//            is NestedRuntimeException -> return ApiResponse(400, e.mostSpecificCause.toString(), null)
//            is BeansException -> return ApiResponse(400, e.message ?: e.toString(), null)
//        }
        return ApiResponse(500, e.message ?: e.toString(), null)
    }
}