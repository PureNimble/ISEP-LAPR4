
package lapr4.jobs4u.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationCode;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
class JpaApplicationRepository
        extends JpaAutoTxRepository<Application, ApplicationCode, ApplicationCode>
        implements ApplicationRepository {

    public JpaApplicationRepository(final TransactionalContext autoTx) {
        super(autoTx, "applicationNumber");
    }

    public JpaApplicationRepository(final String puname) {
        super(puname, lapr4.jobs4u.Application.settings().getExtendedPersistenceProperties(),
                "applicationNumber");
    }

    @Override
    public Optional<Application> findByApplicationCode(final ApplicationCode number) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", number);
        return matchOne("e.applicationNumber=:number", params);
    }

    @Override
    public String findHighestSequenceForCustomer(JobReference jobReference) {

        Long count = createQuery(
                "SELECT COUNT(jo) FROM Application jo WHERE jo.jobOpening.jobReference = :jobReference",
                Long.class)
                .setParameter("jobReference", jobReference)
                .getSingleResult() + 1;
        return count.toString();

    }

    @Override
    public Iterable<Application> filterByJobOpening(JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobOpening", jobOpening);
        return match("e.jobOpening=:jobOpening", params);
    }
}
