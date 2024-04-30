package lapr4.jobs4u.infrastructure.bootstrapers.demo;

import java.util.HashSet;
import java.util.Set;

import lapr4.jobs4u.infrastructure.bootstrapers.UsersBootstrapperBase;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

public class CandidateBootstrapper extends UsersBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerCandidate("Candidate", "Candidate", "ca@email.local", "912345678");
        return true;
    }

    private void registerCandidate(final String firstName, final String lastName, final String email,
            final String phoneNumber) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CANDIDATE);

        addCandidate(firstName, lastName, email, phoneNumber, roles);
    }
}