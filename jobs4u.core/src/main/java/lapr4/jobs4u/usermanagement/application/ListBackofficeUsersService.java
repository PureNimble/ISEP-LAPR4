package lapr4.jobs4u.usermanagement.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
public class ListBackofficeUsersService {
    private final UserRepository userRepository;

    public ListBackofficeUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<SystemUser> backofficeUsers() {
        final Iterable<SystemUser> systemUsers = userRepository.findAll();
        List<SystemUser> userList = new ArrayList<>();
        systemUsers.forEach(userList::add);
        List<SystemUser> filtered = userList.stream()
                .filter(systemUser -> systemUser.hasAny(BaseRoles.nonUserValues()))
                .collect(Collectors.toList());

        return filtered;
    }

}
