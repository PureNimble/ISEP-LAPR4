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
package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.infrastructure.persistence.RepositoryFactory;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
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
    public JpaQuestionRepository question() {
        return new JpaQuestionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaQuestionRepository question(final TransactionalContext autoTx) {
        return new JpaQuestionRepository(autoTx);
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
    public JobOpeningRequirementRepository jobOpeningRequirements() {
        return new JpaJobOpeningRequirementRepository(Application.settings().getPersistenceUnitName());
    }
}
