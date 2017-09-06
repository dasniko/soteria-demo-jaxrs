package dasniko.soteria;

import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@ApplicationPath("/")
@DeclareRoles({"user", "admin", "superadmin"})
@EmbeddedIdentityStoreDefinition({
    @Credentials(callerName = "dasniko", password = "secret", groups = {"user", "admin"}),
    @Credentials(callerName = "john", password = "doe", groups = "user")
})
public class JaxRsApplication extends Application {
}
