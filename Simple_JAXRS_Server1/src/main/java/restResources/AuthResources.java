package restResources;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AuthResources {
    @POST
    @Path("/login")
    public Response auth(@FormParam("login") String login,
                         @FormParam("pass") String pass){
        Response response;
        if(login.equals("user") && pass.equals("123")){
            String token = "1111222233334444";
            response = Response.ok().cookie(new NewCookie("token", token)).entity("Success logged").build();
            return response;
        }
        else{
            response = Response.status(404).entity("Incorrect auth data").build();
            return response;
        }
    }
}
