package lapr4.jobs4u.integration.questions.export.application;

public class QuestionExporterBuilder {

    public QuestionExporter build(FileFormat format) {
        switch (format) {
        case XML:
            return new XmlQuestionExporter();
        case CSV:
            return new CsvQuestionExporter();
        case JSON:
            return new JsonQuestionExporter();
        case INTERVIEW:
            return new InterviewQuestionExporter();
        case REQUIREMENT:
            return new RequirementQuestionExporter();
        }
        throw new IllegalStateException("Unknown format");
    }
}