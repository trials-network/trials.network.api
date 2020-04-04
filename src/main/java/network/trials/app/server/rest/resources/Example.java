package network.trials.app.server.rest.resources;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class Example {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getId() {
        return Response.ok("Hello World").build();
    }
}
