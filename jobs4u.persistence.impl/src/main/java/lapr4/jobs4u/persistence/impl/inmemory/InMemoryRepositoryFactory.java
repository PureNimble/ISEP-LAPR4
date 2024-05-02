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
package lapr4.jobs4u.persistence.impl.inmemory;

import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateUserRepository;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.customermanagement.repositories.CustomerUserRepository;
import lapr4.jobs4u.infrastructure.bootstrapers.Bootstrapper;
import lapr4.jobs4u.infrastructure.persistence.RepositoryFactory;
import lapr4.jobs4u.integration.questions.import_.repositories.QuestionImporterPluginRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.questionmanagement.repositories.QuestionRepository;
import lapr4.jobs4u.questionmanagement.repositories.QuestionTypeRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
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
    public QuestionRepository question(TransactionalContext autoTx) {
        return new InMemoryQuestionRepository();
    }

    @Override
    public QuestionRepository question() {
        return question(null);
    }

    @Override
    public QuestionTypeRepository questionType() {
        return new InMemoryQuestionTypeRepository();
    }

    @Override
    public QuestionTypeRepository questionType(TransactionalContext autoTx) {
        return new InMemoryQuestionTypeRepository();
    }
}