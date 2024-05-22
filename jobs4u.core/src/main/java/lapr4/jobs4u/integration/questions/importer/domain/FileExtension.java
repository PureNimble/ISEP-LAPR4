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
package lapr4.jobs4u.integration.questions.importer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.EqualsAndHashCode;

/**
 * A file extension (without the heading dot, e.g., "pdf", "docx").
 * 
 * @author Paulo Gandra de Sousa 2024.04.30
 */
@Embeddable
@EqualsAndHashCode
public class FileExtension implements ValueObject, Comparable<FileExtension>, StringMixin {

	private static final long serialVersionUID = 1L;

	@XmlAttribute
	@JsonProperty
	private final String fileExtension;

	protected FileExtension(final String name) {
		Preconditions.ensure(StringPredicates.isSingleWord(name) && name.indexOf('.') == -1);

		this.fileExtension = name;
	}

	protected FileExtension() {
		// for ORM
		fileExtension = null;
	}

	public static FileExtension valueOf(final String fileExt) {
		return new FileExtension(fileExt);
	}

	@Override
	public String toString() {
		return fileExtension;
	}

	@Override
	public int compareTo(final FileExtension o) {
		return fileExtension.compareTo(o.fileExtension);
	}
}
