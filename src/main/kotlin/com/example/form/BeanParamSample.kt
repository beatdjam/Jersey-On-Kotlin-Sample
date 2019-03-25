package com.example.form

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotEmpty
import javax.ws.rs.QueryParam

data class BeanParamSample (
        @QueryParam("parameter1")
        val parameter1: String?,

        @QueryParam("parameter2")
        @NotNull
        val parameter2: String?,

        @QueryParam("parameter3")
        @NotEmpty
        val parameter3: String?
)