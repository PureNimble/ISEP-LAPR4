package lapr4.jobs4u.integration.questions.importer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.EqualsAndHashCode;

/**
 * @author 2DI2
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
