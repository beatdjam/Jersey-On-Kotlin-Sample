package com.example

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("parameters")
class ParametersResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/queryparam")
    @Produces(MediaType.TEXT_PLAIN)
    fun queryParam(@QueryParam("parameter") parameter: String?) :String {
        return if(parameter.isNullOrEmpty()) {
            "Parameter is Empty."
        } else parameter
    }
}