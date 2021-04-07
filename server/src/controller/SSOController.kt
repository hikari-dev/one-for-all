package dev.hikari.oneforall.controller

import dev.hikari.oneforall.dto.ApiResponse
import dev.hikari.oneforall.dto.RegisterDTO
import dev.hikari.oneforall.dto.responseOk
import dev.hikari.oneforall.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ServerWebExchange
import springfox.documentation.annotations.ApiIgnore
import javax.validation.Valid

@Api(tags = ["认证服务"])
@RestController
@RequestMapping("/v1/sso")
class SSOController(
    private val userService: UserService
) {

    @ApiOperation("注册")
    @PostMapping("/register")
    suspend fun register(
        @RequestBody
        @Valid
        registerDTO: RegisterDTO,
        @ApiIgnore
        exchange: ServerWebExchange
    ): ApiResponse<Int> {
        val result = userService.registerUser(registerDTO, exchange.request.remoteAddress.toString())
        return responseOk(result)
    }
}