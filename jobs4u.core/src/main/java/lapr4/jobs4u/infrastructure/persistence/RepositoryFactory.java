/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package lapr4.jobs4u.infrastructure.persistence;

import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateUserRepository;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.customermanagement.repositories.CustomerUserRepository;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.questionmanagement.repositories.InterviewQuestionRepository;
import lapr4.jobs4u.questionmanagement.repositories.QuestionTypeRepository;
import lapr4.jobs4u.questionmanagement.repositories.RequirementsQuestionRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the
     * repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    CustomerRepository customers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CustomerRepository customers();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    CandidateRepository candidates(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CandidateRepository candidates();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    CustomerUserRepository customerUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CustomerUserRepository customerUsers();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    CandidateUserRepository candidateUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CandidateUserRepository candidateUsers();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    RecruitmentProcessRepository recruitmentProcesses(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    RecruitmentProcessRepository recruitmentProcesses();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    JobOpeningRepository jobOpenings(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    JobOpeningRepository jobOpenings();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    ApplicationRepository applications(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @returnp
     */
    ApplicationRepository applications();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    InterviewQuestionRepository interviewQuestion(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    InterviewQuestionRepository interviewQuestion();

    /**
     *
     * @param autoTx
     *               the transactional context to enroll
     * @return
     */
    RequirementsQuestionRepository requirementsQuestion(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    RequirementsQuestionRepository requirementsQuestion();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    QuestionImporterPluginRepository questionImporterPlugins(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @returnp
     */
    QuestionImporterPluginRepository questionImporterPlugins();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    QuestionTypeRepository questionType(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    QuestionTypeRepository questionType();

    /**
     *
     * @param autoTx
     *               the transactional context to enroll
     * @return
     */
    JobOpeningInterviewRepository jobOpeningInterviews(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    JobOpeningInterviewRepository jobOpeningInterviews();

    /**
     *
     * @param autoTx
     *               the transactional context to enroll
     * @return
     */
    JobOpeningRequirementRepository jobOpeningRequirements(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    JobOpeningRequirementRepository jobOpeningRequirements();

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    InterviewRepository interviews();

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    RequirementRepository requirements();

}
