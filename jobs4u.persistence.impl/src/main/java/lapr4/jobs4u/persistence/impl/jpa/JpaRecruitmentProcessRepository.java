package lapr4.jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;

class JpaRecruitmentProcessRepository extends JpaAutoTxRepository<RecruitmentProcess, Long, Long>
        implements RecruitmentProcessRepository {
    public JpaRecruitmentProcessRepository(final TransactionalContext autoTx) {
        super(autoTx, "pk");
    }

    public JpaRecruitmentProcessRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "pk");
    }

    /* @Override
    public Iterable<RecruitmentProcess> findAllActive() {
        return match("e.active = true");
    } */

}
