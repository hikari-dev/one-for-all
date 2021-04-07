package dev.hikari.oneforall.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("通用返回")
class ApiResponse<T>(
    @ApiModelProperty("状态码", example = "200")
    val code: Int,
    @ApiModelProperty("提示信息")
    val message: String? = null,
    @ApiModelProperty("返回数据")
    val response: T? = null
)

fun <T> responseOk(content: T) = ApiResponse(200, "", content)