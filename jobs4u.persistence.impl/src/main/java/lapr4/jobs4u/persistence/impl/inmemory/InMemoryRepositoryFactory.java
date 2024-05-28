package lapr4.jobs4u.persistence.impl.inmemory;

import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateUserRepository;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.customermanagement.repositories.CustomerUserRepository;
import lapr4.jobs4u.infrastructure.bootstrapers.Bootstrapper;
import lapr4.jobs4u.infrastructure.persistence.RepositoryFactory;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.questionmanagement.repositories.InterviewQuestionRepository;
import lapr4.jobs4u.questionmanagement.repositories.QuestionTypeRepository;
import lapr4.jobs4u.questionmanagement.repositories.RequirementsQuestionRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

/**
 * @author 2DI2
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new Bootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

    @Override
    public CustomerRepository customers(final TransactionalContext tx) {
        return new InMemoryCustomerRepository();
    }

    @Override
    public CustomerRepository customers() {
        return customers(null);
    }

    @Override
    public CandidateRepository candidates(final TransactionalContext tx) {
        return new InMemoryCandidateRepository();
    }

    @Override
    public CandidateRepository candidates() {
        return candidates(null);
    }

    @Override
    public CandidateUserRepository candidateUsers(final TransactionalContext tx) {
        return new InMemoryCandidateUserRepository();
    }

    @Override
    public CandidateUserRepository candidateUsers() {
        return candidateUsers(null);
    }

    @Override
    public CustomerUserRepository customerUsers(final TransactionalContext tx) {
        return new InMemoryCustomerUserRepository();
    }

    @Override
    public CustomerUserRepository customerUsers() {
        return customerUsers(null);
    }

    @Override
    public RecruitmentProcessRepository recruitmentProcesses(final TransactionalContext tx) {
        return new InMemoryRecruitmentProcessRepository();
    }

    @Override
    public RecruitmentProcessRepository recruitmentProcesses() {
        return recruitmentProcesses(null);
    }

    @Override
    public JobOpeningRepository jobOpenings(final TransactionalContext tx) {
        return new InMemoryJobOpeningRepository();
    }

    @Override
    public JobOpeningRepository jobOpenings() {
        return jobOpenings(null);
    }

    @Override
    public ApplicationRepository applications(final TransactionalContext tx) {
        return new InMemoryApplicationRepository();
    }

    @Override
    public ApplicationRepository applications() {
        return applications(null);
    }

    @Override
    public QuestionImporterPluginRepository questionImporterPlugins(final TransactionalContext tx) {
        return new InMemoryQuestionImporterPluginRepository();
    }

    @Override
    public QuestionImporterPluginRepository questionImporterPlugins() {
        return questionImporterPlugins(null);
    }

    @Override
    public InterviewQuestionRepository interviewQuestion(TransactionalContext autoTx) {
        return new InMemoryInterviewQuestionRepository();
    }

    @Override
    public InterviewQuestionRepository interviewQuestion() {
        return interviewQuestion(null);
    }

    @Override
    public RequirementsQuestionRepository requirementsQuestion(TransactionalContext autoTx) {
        return new InMemoryRequirementsQuestionRepository();
    }

    @Override
    public RequirementsQuestionRepository requirementsQuestion() {
        return requirementsQuestion(null);
    }

    @Override
    public QuestionTypeRepository questionType() {
        return new InMemoryQuestionTypeRepository();
    }

    @Override
    public QuestionTypeRepository questionType(TransactionalContext autoTx) {
        return questionType(null);
    }

    @Override
    public JobOpeningInterviewRepository jobOpeningInterviews() {
        return new InMemoryJobOpeningInterviewRepository();
    }

    @Override
    public JobOpeningInterviewRepository jobOpeningInterviews(TransactionalContext autoTx) {
        return jobOpeningInterviews(null);
    }

    @Override
    public JobOpeningRequirementRepository jobOpeningRequirements() {
        return new InMemoryJobOpeningRequirementRepository();
    }

    @Override
    public JobOpeningRequirementRepository jobOpeningRequirements(TransactionalContext autoTx) {
        return jobOpeningRequirements(null);
    }

    @Override
    public InterviewRepository interviews() {
        return new InMemoryInterviewRepository();
    }

    @Override
    public InterviewRepository interviews(TransactionalContext autoTx) {
        return interviews(null);
    }

    @Override
    public RequirementRepository requirements() {
        return new InMemoryRequirementRepository();
    }

    @Override
    public RequirementRepository requirements(TransactionalContext autoTx) {
        return requirements(null);
    }
}