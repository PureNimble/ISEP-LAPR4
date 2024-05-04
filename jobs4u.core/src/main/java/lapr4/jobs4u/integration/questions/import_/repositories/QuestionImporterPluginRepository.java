/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.integration.questions.import_.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;
import lapr4.jobs4u.integration.questions.import_.domain.FileExtension;
import lapr4.jobs4u.integration.questions.import_.domain.PluginType;
import lapr4.jobs4u.integration.questions.import_.domain.QuestionImporterPlugin;

/**
 *
 * @author Paulo Gandra de Sousa 2024.04.30
 */
public interface QuestionImporterPluginRepository extends DomainRepository<Designation, QuestionImporterPlugin> {

	Optional<QuestionImporterPlugin> findByFileExtension(final FileExtension fileExt);
	Optional<QuestionImporterPlugin> findByName(final Designation name);
	Iterable<QuestionImporterPlugin> findByPluginType(final PluginType pluginType);
}