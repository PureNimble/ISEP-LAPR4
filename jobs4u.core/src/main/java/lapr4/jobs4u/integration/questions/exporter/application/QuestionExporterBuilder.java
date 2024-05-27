package lapr4.jobs4u.integration.questions.exporter.application;

/**
 * @author 2DI2
 */
public class QuestionExporterBuilder {

    public QuestionExporter build(final FileFormat format) {
        switch (format) {
            case INTERVIEW:
                return new InterviewExporter();
            case REQUIREMENT:
                return new RequirementsExporter();
        }
        throw new IllegalStateException("Unknown format");
    }
}