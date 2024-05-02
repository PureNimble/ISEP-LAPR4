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
package lapr4.jobs4u.integration.questions.import_.domain;

import java.lang.reflect.InvocationTargetException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.integration.questions.import_.application.QuestionImporter;

/**
 * The configuration entry of an importer plugin.
 * 
 * @author Paulo Gandra de Sousa 2024.04.30
 */
@Entity
@Table(name = "T_QUESTION_IMPORTER_PLUGIN")
public class QuestionImporterPlugin implements AggregateRoot<Designation> {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LogManager.getLogger(QuestionImporterPlugin.class);

	@Id
	@GeneratedValue
	private Long pk;

	@Version
	private Long version;

	// business id
	@Column(nullable = false, unique = true)
	private final Designation name;

	private final Description description;

	private final FileExtension fileExtension;

	private final FQClassName className;

	protected QuestionImporterPlugin() {
		// for ORM only
		name = null;
		description = null;
		fileExtension = null;
		className = null;
	}

	public QuestionImporterPlugin(final String name2, final String description2, final String fileExtension2,
			final String fqClassName) {
		Preconditions.noneNull(name2, description2, fileExtension2, fqClassName);

		name = Designation.valueOf(name2);
		description = Description.valueOf(description2);
		fileExtension = FileExtension.valueOf(fileExtension2);
		className = FQClassName.valueOf(fqClassName);
	}

	@Override
	public boolean sameAs(final Object other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Designation identity() {
		return name;
	}

	public FileExtension fileExtension() {
		return fileExtension;
	}

	/**
	 * Dynamically loads and builds the plugin importer.
	 * 
	 * @return
	 */
	public QuestionImporter buildImporter() {
		try {
			return (QuestionImporter) Class.forName(className.toString()).getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException ex) {
			LOGGER.error("Unable to dynamically load the Plugin", ex);
			throw new IllegalStateException("Unable to dynamically load the Plugin: " + className.toString(), ex);
		}
	}
}