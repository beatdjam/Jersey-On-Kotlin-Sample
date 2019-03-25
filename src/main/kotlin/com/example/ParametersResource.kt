package com.example

import com.example.form.BeanParamSample
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
     *
     * @return request parameter string
     */
    @GET
    @Path("/beanparam")
    @Produces(MediaType.TEXT_PLAIN)
    fun beanparam(@BeanParam parameter: BeanParamSample) :String {
        return buildString {
            appendln(parameter.parameter1)
            appendln(parameter.parameter2)
            appendln(parameter.parameter3)
        }
    }
}