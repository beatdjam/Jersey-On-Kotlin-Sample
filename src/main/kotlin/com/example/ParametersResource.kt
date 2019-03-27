package com.example

import com.example.form.BeanParamSample
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("parameters")
class ParametersResource {

    /**
     * This method return object is request parameter string.
     *
     * @return request parameter string
     */
    @GET
    @Path("/queryparam")
    @Produces(MediaType.TEXT_PLAIN)
    fun queryParam(@QueryParam("parameter") parameter: String?) :String {
        return if(parameter.isNullOrEmpty()) {
            "Parameter is Empty."
        } else parameter
    }

    /**
     * This method return object is request parameter strings,
     *
     * @return request parameter string
     */
    @GET
    @Path("/beanparam")
    @Produces(MediaType.TEXT_PLAIN)
    fun beanparam(@BeanParam @Valid parameter: BeanParamSample) :String {
        return buildString {
            appendln(
                if(parameter.parameter1.isNullOrEmpty()) {
                    "Parameter is Empty."
                } else parameter.parameter1
            )
            appendln(parameter.parameter2)
            appendln(parameter.parameter3)
        }
    }

    /**
     * This method return object is path parameter strings.
     *
     * @return path parameter string
     */
    @GET
    @Path("/pathparam/{parameter}")
    fun pathParam(@PathParam("parameter") parameter: String?): String {
        return if (parameter.isNullOrEmpty()) {
            "Parameter is Empty."
        } else parameter
    }
    
    /**
     * This method return object is joined path parameter strings.
     *
     * @return path parameter string
     */
    @GET
    @Path("/pathparam/{parameter1}.{parameter2}")
    fun pathParamSplit(
            @PathParam("parameter1") parameter1: String?,
            @PathParam("parameter2") parameter2: String?
    ): String {

        return (parameter1 ?: "") + "-" +  (parameter2 ?: "")
    }
}