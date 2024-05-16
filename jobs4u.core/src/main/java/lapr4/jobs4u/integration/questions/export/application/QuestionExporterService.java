package lapr4.jobs4u.integration.questions.export.application;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.util.TemplateMethod;
import lapr4.jobs4u.questionmanagement.domain.Question;

public class QuestionExporterService  {
    private static final Logger logger = LogManager.getLogger(QuestionExporterService.class);

    /**
     * Exports questions. This a "template method" working in conjunction with a Strategy.
     * If the {@link DishExporter} interface had just the export method we would be repeating the
     * logic of traversing the dish list in every implementation!
     *
     * <p>
     * Note that the exporter receives an Iterable and as such you should take attention to the
     * volume of data to export. If you need to export a large volume of data you should provide
     * some kind of cursor-based iterable and not a pure in-memory collection.
     *
     * @param questions
     * @param filename
     * @param exporter
     * @throws IOException
     */
    @TemplateMethod
    public void export(final Iterable<Question> questions, final String filename, final QuestionExporter exporter, final String plugin)
            throws IOException {
        try {
            exporter.begin(filename, plugin);

            boolean hasPrevious = false;
            for (final Question e : questions) {
                if (hasPrevious) {
                    exporter.elementSeparator();
                }

                exporter.element(e);
                hasPrevious = true;
            }

            exporter.end();
        } catch (final IOException e) {
            logger.error("Problem exporting questions", e);
            throw e;
        } finally {
            exporter.cleanup();
        }
    }
}