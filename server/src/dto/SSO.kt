package dev.hikari.oneforall.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Email

@ApiModel
data class RegisterDTO(
    @ApiModelProperty("邮箱", example = "foo@example.com")
    @field:Email
    val email: String,
    @ApiModelProperty("昵称")
    val nick: String,
    @ApiModelProperty("密码")
    val password: String
)

@ApiModel
data class LoginDTO(
    @ApiModelProperty("邮箱", example = "foo@example.com")
    @field:Email
    val email: String,
    @ApiModelProperty("密码")
    val password: String
)