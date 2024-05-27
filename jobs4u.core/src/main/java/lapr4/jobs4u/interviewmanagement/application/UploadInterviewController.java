package lapr4.jobs4u.interviewmanagement.application;

import java.io.IOException;
import java.util.Optional;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
@UseCaseController
public class UploadInterviewController {
    private final UploadInterviewService uploadInterviewService;
    private final AuthorizationService authz;

    public UploadInterviewController(final InterviewRepository interviewRepository, final AuthorizationService authz) {
        this.uploadInterviewService = new UploadInterviewService(interviewRepository);
        this.authz = authz;
    }

    public void registerInterview(final Interview interview, final String filePath) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        final File file = File.valueOf(filePath);
        uploadInterviewService.registerInterview(interview, file);
    }

    public boolean isCorrectInterview(final Interview interview, final String filePath) throws IOException {
        return uploadInterviewService.isCorrectInterview(interview, filePath);
    }

    public Interview findInterview(final Application application) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        Optional<Interview> i = uploadInterviewService.findInterview(application);

        if (i.isPresent()) {
            return i.get();
        }
        return null;
    }

}