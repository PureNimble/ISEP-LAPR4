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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.integration.questions.importer.domain.FileExtension;
import lapr4.jobs4u.integration.questions.importer.domain.PluginType;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;

/**
 * @author Paulo Gandra de Sousa 2024.04.30
 */
public class JpaQuestionImporterPluginRepository extends JpaAutoTxRepository<QuestionImporterPlugin, Long, Designation>
		implements QuestionImporterPluginRepository {

	public JpaQuestionImporterPluginRepository(final TransactionalContext autoTx) {
		super(autoTx, "name");
	}

	public JpaQuestionImporterPluginRepository(final String puname) {
		super(puname, Application.settings().getExtendedPersistenceProperties(),
				"name");
	}

	@Override
	public Optional<QuestionImporterPlugin> findByFileExtension(final FileExtension fileExt) {
		final Map<String, Object> params = new HashMap<>();
		params.put("fileExt", fileExt);
		return matchOne("e.fileExtension=:fileExt", params);
	}

	@Override
    public Iterable<QuestionImporterPlugin> findByPluginType(PluginType pluginType) {
        final Map<String, Object> params = new HashMap<>();
		params.put("pluginType", pluginType);
		return match("e.pluginType=:pluginType", params);
    }

	@Override
	public Optional<QuestionImporterPlugin> findByName(final Designation name) {
		final Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		return matchOne("e.name=:name", params);
	}
}