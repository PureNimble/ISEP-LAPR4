package lapr4.jobs4u.integration.questions.importer.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

/**
 * @author 2DI2
 */
@Embeddable
public class PluginType implements ValueObject, Comparable<PluginType>{

    private static final long serialVersionUID = 1L;

    private final String pluginType;

    protected PluginType(final String pluginType) {
        Preconditions.nonEmpty(pluginType, "Plugin Type should neither be null nor empty");
        Preconditions.ensure(TypesOfPlugins.valueOf(pluginType) != null, "Plugin Type must be either INTERVIEW or REQUIREMENT");
        this.pluginType = pluginType;
    }

    protected PluginType() {
        this.pluginType = "";
    }

    public static PluginType valueOf(final String pluginType) {
        return new PluginType(pluginType);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PluginType)) {
            return false;
        }

        final PluginType that = (PluginType) o;
        return this.pluginType.equals(that.pluginType);
    }

    @Override
    public int hashCode() {
        return this.pluginType.hashCode();
    }

    @Override
    public String toString() {
        return this.pluginType;
    }

    @Override
    public int compareTo(final PluginType arg0) {
        return pluginType.compareTo(arg0.pluginType);
    }

}
