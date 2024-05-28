package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.infrastructure.persistence.RepositoryFactory;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * @author 2DI2
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaCustomerRepository customers(final TransactionalContext autoTx) {
        return new JpaCustomerRepository(autoTx);
    }

    @Override
    public JpaCustomerRepository customers() {
        return new JpaCustomerRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaCandidateRepository candidates(final TransactionalContext autoTx) {
        return new JpaCandidateRepository(autoTx);
    }

    @Override
    public JpaCandidateRepository candidates() {
        return new JpaCandidateRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaCandidateUserRepository candidateUsers(final TransactionalContext autoTx) {
        return new JpaCandidateUserRepository(autoTx);
    }

    @Override
    public JpaCandidateUserRepository candidateUsers() {
        return new JpaCandidateUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaCustomerUserRepository customerUsers(final TransactionalContext autoTx) {
        return new JpaCustomerUserRepository(autoTx);
    }

    @Override
    public JpaCustomerUserRepository customerUsers() {
        return new JpaCustomerUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaRecruitmentProcessRepository recruitmentProcesses(final TransactionalContext autoTx) {
        return new JpaRecruitmentProcessRepository(autoTx);
    }

    @Override
    public JpaRecruitmentProcessRepository recruitmentProcesses() {
        return new JpaRecruitmentProcessRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaJobOpeningRepository jobOpenings(final TransactionalContext autoTx) {
        return new JpaJobOpeningRepository(autoTx);
    }

    @Override
    public JpaJobOpeningRepository jobOpenings() {
        return new JpaJobOpeningRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaApplicationRepository applications(final TransactionalContext autoTx) {
        return new JpaApplicationRepository(autoTx);
    }

    @Override
    public JpaApplicationRepository applications() {
        return new JpaApplicationRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaInterviewQuestionRepository interviewQuestion() {
        return new JpaInterviewQuestionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaInterviewQuestionRepository interviewQuestion(final TransactionalContext autoTx) {
        return new JpaInterviewQuestionRepository(autoTx);
    }

    @Override
    public JpaRequirementsQuestionRepository requirementsQuestion() {
        return new JpaRequirementsQuestionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaRequirementsQuestionRepository requirementsQuestion(final TransactionalContext autoTx) {
        return new JpaRequirementsQuestionRepository(autoTx);
    }

    @Override
    public JpaQuestionImporterPluginRepository questionImporterPlugins() {
        return new JpaQuestionImporterPluginRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaQuestionImporterPluginRepository questionImporterPlugins(final TransactionalContext autoTx) {
        return new JpaQuestionImporterPluginRepository(autoTx);
    }

    @Override
    public JpaQuestionTypeRepository questionType() {
        return new JpaQuestionTypeRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaQuestionTypeRepository questionType(final TransactionalContext autoTx) {
        return new JpaQuestionTypeRepository(autoTx);
    }

    @Override
    public JobOpeningInterviewRepository jobOpeningInterviews() {
        return new JpaJobOpeningInterviewRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JobOpeningInterviewRepository jobOpeningInterviews(TransactionalContext autoTx) {
        return new JpaJobOpeningInterviewRepository(autoTx);
    }

    @Override
    public JobOpeningRequirementRepository jobOpeningRequirements() {
        return new JpaJobOpeningRequirementRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JobOpeningRequirementRepository jobOpeningRequirements(TransactionalContext autoTx) {
        return new JpaJobOpeningRequirementRepository(autoTx);
    }

    @Override
    public InterviewRepository interviews() {
        return new JpaInterviewRepository(Application.settings().getPersistenceUnitName());
    }

    @Override   
    public InterviewRepository interviews(TransactionalContext autoTx) {
        return new JpaInterviewRepository(autoTx);
    }

    @Override
    public RequirementRepository requirements() {
        return new JpaRequirementRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public RequirementRepository requirements(TransactionalContext autoTx) {
        return new JpaRequirementRepository(autoTx);
    }
}
