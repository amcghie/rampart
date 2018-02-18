package au.com.alwaysagile.rampart.resources;

import au.com.alwaysagile.rampart.views.ExampleView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/example")
@Produces(MediaType.TEXT_HTML)
public class ExampleResource {

    @GET
    public ExampleView showExample() {
        return new ExampleView("Bob");
    }
}
