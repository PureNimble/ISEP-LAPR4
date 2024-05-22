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
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.EqualsAndHashCode;

/**
 * A fully qualified class name. i.e., includes the full package structure.
 * <p>
 * E.g.
 * <p>
 * <code>
 * eapli.ecafeteria.integrations.plugins.dish.alternate.AlternateFormatImporter
 * </code>
 * 
 * @author Paulo Gandra de Sousa 2024.04.30
 */
@Embeddable
@EqualsAndHashCode
public class FQClassName implements ValueObject, Comparable<FQClassName>, StringMixin {

	private static final long serialVersionUID = 1L;

	@XmlAttribute
	@JsonProperty
	private final String fqClassName;

	protected FQClassName(final String name) {
		Preconditions.nonEmpty(name);
		// TODO check if it is a FQName

		this.fqClassName = name;
	}

	protected FQClassName() {
		// for ORM
		fqClassName = null;
	}

	public static FQClassName valueOf(final String fqClassName) {
		return new FQClassName(fqClassName);
	}

	@Override
	public String toString() {
		return fqClassName;
	}

	@Override
	public int compareTo(final FQClassName o) {
		return fqClassName.compareTo(o.fqClassName);
	}
}
