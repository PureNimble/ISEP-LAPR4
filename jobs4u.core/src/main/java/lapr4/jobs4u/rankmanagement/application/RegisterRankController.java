package lapr4.jobs4u.rankmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.domain.RankBuilder;
import lapr4.jobs4u.rankmanagement.domain.RankPlacement;
import lapr4.jobs4u.rankmanagement.dto.RankDTO;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class RegisterRankController {

    private final AuthorizationService authz;
    private final RankRepository repository;
    private final RegisterRankService service;

    public RegisterRankController(AuthorizationService authz, RankRepository repository) {
        this.authz = authz;
        this.repository = repository;
        this.service = new RegisterRankService(repository);
    }

    public Rank setupRank(final String rankPlacement, final Application application) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return registerRank(rankPlacement, application);
    }

    private Rank registerRank(final String rankPlacement, final Application application) {
        final Rank rank = doSetupRank(rankPlacement, application);
        return repository.save(rank);
    }

    private Rank doSetupRank(final String rankPlacement, final Application application) {
        return new RankBuilder().with(rankPlacement, application).build();
    }

    public Boolean hasRank(final JobOpening jobOpening) {
        return service.hasRank(jobOpening);
    }

    public Iterable<RankDTO> findByJobOpening(final JobOpening jobOpening) {
        return service.findByJobOpening(jobOpening);
    }

    public Rank selectedRank(final RankDTO rankDTO) {
        return service.selectedRank(rankDTO);
    }

    public Rank editRank(final Rank rank, final String rankPlacement) {
        rank.replace(RankPlacement.valueOf(rankPlacement));
        return repository.save(rank);
    }
}
