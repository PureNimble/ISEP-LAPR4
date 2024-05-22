package lapr4.jobs4u.integration.questions.exporter.application;

import java.io.IOException;

import lapr4.jobs4u.questionmanagement.domain.Question;

public interface QuestionExporter {

    /**
     * Initiate the export process. The implementation should open the underlying resource (e.g., file) and create the
     * "document start"/"header" for the respective format.
     *
     * @param filename
     */
    void begin(final String filename, final String plugin) throws IOException;
    void begin(final String filename) throws IOException;

    /**
     * Export one single element.
     *
     * @param e
     */
    void element(final Question e);

    /**
     * Indicates that a new element will be created.
     */
    void elementSeparator();

    /**
     * Indicates that there are no more elements to export. The implementation should create any "document closing"
     * element it might need and close the underlying resource.
     */
    void end();

    /**
     * Gives the exporter implementation a change to cleanup in case some exception has occurred.
     */
    void cleanup();
}
