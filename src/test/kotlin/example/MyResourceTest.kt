package example

import com.example.Main
import org.glassfish.grizzly.http.server.HttpServer
import org.junit.After
import org.junit.Before
import org.junit.Test

import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.WebTarget

import org.junit.Assert.assertEquals

class MyResourceTest {

    private lateinit var server: HttpServer
    private lateinit var target: WebTarget

    @Before
    @Throws(Exception::class)
    fun setUp() {
        // start the server
        server = Main.startServer()
        // create the client
        val c = ClientBuilder.newClient()

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());
        target = c.target(Main.BASE_URI)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        server.shutdownNow()
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    fun testGetIt() {
        val responseMsg = target.path("myresource").request().get(String::class.java)
        assertEquals("Got it!", responseMsg)
    }
}
