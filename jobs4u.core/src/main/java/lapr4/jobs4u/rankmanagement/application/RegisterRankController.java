package lapr4.jobs4u.rankmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.domain.RankBuilder;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

public class RegisterRankController {

    private final AuthorizationService authz;

    private final RankRepository repository;

    private final RegisterRankService service;

    public RegisterRankController(AuthorizationService authz, RankRepository repository) {
        this.authz = authz;
        this.repository = repository;
        this.service = new RegisterRankService(repository);
    }

    public Rank setupRank(final String rankPlacement, final Application candidate, final JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        String rankReference = service.nextRankReference();
        return registerRank(rankReference,rankPlacement, candidate, jobOpening);
    }

    private Rank registerRank(final String rankReference, final String rankPlacement, final Application candidate, final JobOpening jobOpening) {
        final Rank rank = doSetupRank(rankReference,rankPlacement,candidate,jobOpening);
        return repository.save(rank);
    }

    private Rank doSetupRank(final String rankReference, final String rankPlacement, final Application candidate, final JobOpening jobOpening) {
        return new RankBuilder().with(rankReference,rankPlacement,candidate,jobOpening).build();
    }
}
