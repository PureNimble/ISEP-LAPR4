package lapr4.jobs4u.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerUser;
import lapr4.jobs4u.customermanagement.repositories.CustomerUserRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;

/**
 * @author 2DI2
 */
public class DatabasePollingService implements Runnable {

    private final Logger LOGGER = LogManager.getLogger(DatabasePollingService.class);

    private final RecruitmentProcessRepository recruitmentProcessRepository;
    private final CustomerUserRepository customerUserRepository;
    private Map<Long, String> previousRecruitmentProcess;
    private final EventListener eventListener;

    public DatabasePollingService(RecruitmentProcessRepository recruitmentProcessRepository,
            CustomerUserRepository customerUserRepository,
            EventListener eventListener) {
        this.recruitmentProcessRepository = recruitmentProcessRepository;
        this.customerUserRepository = customerUserRepository;
        this.eventListener = eventListener;
        this.previousRecruitmentProcess = new HashMap<>();
    }

    @Override
    public void run() {
        loadPreviousRecruitmentProcess();
        while (true) {
            LOGGER.info("Database polling service running...");
            pollDatabase();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.info("Database polling service interrupted: " + e.getMessage());
                break;
            }
        }
    }

    private void pollDatabase() {
        pollRecruitmentProcess();
    }

    private void pollRecruitmentProcess() {
        final Iterable<RecruitmentProcess> currentRecruitmentProcess = recruitmentProcessRepository.findAll();
        for (final RecruitmentProcess currentState : currentRecruitmentProcess) {
            String previousState = previousRecruitmentProcess.getOrDefault(currentState.identity(), "No Phase");

            final JobOpening jobOpening = currentState.jobOpening();
            final Optional<String> stateOpt = recruitmentProcessRepository.currentPhase(jobOpening);
            final String state = stateOpt.orElse("No Phase");

            if (!previousState.equals(state)) {
                LOGGER.info("Recruitment process " + currentState.identity() + " changed from " + previousState + " to "
                        + state);
                addCustomerNotification(jobOpening, state);
            } else {
                LOGGER.info("No changes in recruitment process " + currentState.identity());
            }

            previousRecruitmentProcess.put(currentState.identity(), state);
        }
    }

    private void addCustomerNotification(final JobOpening jobOpening, final String state) {
        final Customer customer = jobOpening.customer();
        final Optional<CustomerUser> customerUser = customerUserRepository.findByCustomerCode(customer.customerCode());

        if (customerUser.isPresent()) {
            final SystemUser user = customerUser.get().user();
            eventListener.addNotification(user, new ProtocolMessage((byte) 1, MessageCode.NOTIFICATION,
                    "Your job opening " + jobOpening.jobReference() + " is now in " + state.toString() + " state."));
        }
    }

    private void loadPreviousRecruitmentProcess() {
        final Iterable<RecruitmentProcess> currentRecruitmentProcess = recruitmentProcessRepository.findAll();
        for (final RecruitmentProcess currentState : currentRecruitmentProcess) {
            final JobOpening jobOpening = currentState.jobOpening();
            final Optional<String> stateOpt = recruitmentProcessRepository.currentPhase(jobOpening);
            final String state = stateOpt.orElse("No Phase");

            previousRecruitmentProcess.put(currentState.identity(), state);
        }
    }
}
