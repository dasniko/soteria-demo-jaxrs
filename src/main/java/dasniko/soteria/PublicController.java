package dasniko.soteria;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.security.Principal;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Path("public")
public class PublicController {

    @GET
    @Path("hi")
    public JsonObject getUser(@Context HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            return Json.createObjectBuilder()
                .add("username", principal.getName())
                .add("isUser", request.isUserInRole("user"))
                .add("isAdmin", request.isUserInRole("admin"))
                .add("isSuperadmin", request.isUserInRole("superadmin"))
                .build();
        }
        return Json.createObjectBuilder().add("public", true).build();
    }
}
