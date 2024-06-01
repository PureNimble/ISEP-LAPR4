
package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * @author 2DI2
 */
class JpaInterviewRepository extends JpaAutoTxRepository<Interview, Long, Long> implements InterviewRepository {

    public JpaInterviewRepository(final TransactionalContext autoTx) {
        super(autoTx, "ID");
    }

    public JpaInterviewRepository(final String puname) {
        super(puname, lapr4.jobs4u.Application.settings().getExtendedPersistenceProperties(), "ID");
    }

    @Override
    public Optional<Interview> findInterviewByApplication(final Application application) {
        final Map<String, Object> params = new HashMap<>();
        params.put("application", application);
        return matchOne("e.application=:application", params);
    }

    @Override
    public Iterable<Interview> findNonGradedInterviewsByJobOpening(final JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobOpening", jobOpening);
        return match("e.application.jobOpening=:jobOpening AND e.grade IS NULL", params);
    }

}
