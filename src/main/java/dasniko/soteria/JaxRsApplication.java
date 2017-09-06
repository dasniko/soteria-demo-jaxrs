package dasniko.soteria;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@ApplicationPath("/")
@DeclareRoles({"user", "admin", "superadmin"})
public class JaxRsApplication extends Application {
}
