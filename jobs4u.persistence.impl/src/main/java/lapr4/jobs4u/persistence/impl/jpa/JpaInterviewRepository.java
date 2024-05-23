
package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
class JpaInterviewRepository extends JpaAutoTxRepository<Interview, Long, Long> implements InterviewRepository {

    public JpaInterviewRepository(final TransactionalContext autoTx) {
        super(autoTx, "applicationcode");
    }

    public JpaInterviewRepository(final String puname) {
        super(puname, lapr4.jobs4u.Application.settings().getExtendedPersistenceProperties(), "applicationcode");
    }

}
