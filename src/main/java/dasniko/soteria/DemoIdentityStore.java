package dasniko.soteria;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@ApplicationScoped
public class DemoIdentityStore implements IdentityStore {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (((UsernamePasswordCredential) credential).compareTo("dasniko", "secret")) {
            return new CredentialValidationResult("dasniko", new HashSet<>(Arrays.asList("user", "admin")));
        }

        return CredentialValidationResult.INVALID_RESULT;
    }
}
