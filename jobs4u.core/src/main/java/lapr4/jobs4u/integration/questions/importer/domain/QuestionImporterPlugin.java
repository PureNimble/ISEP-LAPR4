package lapr4.jobs4u.integration.questions.importer.domain;

import java.lang.reflect.InvocationTargetException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lapr4.jobs4u.integration.questions.importer.application.QuestionImporter;

/**
 * The configuration entry of an importer plugin.
 * 
 *
 * @author 2DI2
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

	@Column(nullable = false)
	private final Description description;

	@Column(nullable = false)
	private final FileExtension fileExtension;

	@Column(nullable = false)
	private final FQClassName className;

	@Column(nullable = false)
	private final PluginType pluginType;

	protected QuestionImporterPlugin() {
		// for ORM only
		this.name = null;
		this.description = null;
		this.fileExtension = null;
		this.className = null;
		this.pluginType = null;
	}

	public QuestionImporterPlugin(final Designation name, final Description description, final FileExtension fileExtension,
			final FQClassName fqClassName, final PluginType pluginType) {
		Preconditions.noneNull(name, description, fileExtension, fqClassName, pluginType);

		this.name = name;
		this.description = description;
		this.fileExtension = fileExtension;
		this.className = fqClassName;
		this.pluginType = pluginType;
	}

	@Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

	@Override
	public Designation identity() {
		return name;
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

	public FileExtension fileExtension() {
		return fileExtension;
	}

	public PluginType pluginType() {
		return pluginType;
	}

	@Override
	public String toString() {
		return name.toString();
	}
}