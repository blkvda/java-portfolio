package restResources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/notification")
public class NotificationResource {
    @GET
    @Path("/ping")
    public Response ping(){
        System.out.println("Input request");
        return Response.ok().entity("Service online").cookie(new NewCookie("myCookie", "testCookie")).build();
    }
}
