package com.example.form

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.ws.rs.QueryParam

data class BeanParamSample (
        @QueryParam("parameter1")
        val parameter1: String?,

        @QueryParam("parameter2")
        @field:NotNull
        val parameter2: String?,

        @QueryParam("parameter3")
        @field:NotEmpty
        val parameter3: String?
)