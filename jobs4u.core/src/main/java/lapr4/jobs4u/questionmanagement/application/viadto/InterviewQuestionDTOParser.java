package lapr4.jobs4u.questionmanagement.application.viadto;

import eapli.framework.representations.dto.DTOParser;
import lapr4.jobs4u.questionmanagement.domain.InterviewQuestion;
import lapr4.jobs4u.questionmanagement.domain.InterviewQuestionBuilder;
import lapr4.jobs4u.questionmanagement.dto.InterviewQuestionDTO;
import lapr4.jobs4u.questionmanagement.repositories.QuestionTypeRepository;

/**
 * @author 2DI2
 */
public class InterviewQuestionDTOParser implements DTOParser<InterviewQuestionDTO, InterviewQuestion> {

    private final QuestionTypeRepository questionTypeRepository;

    public InterviewQuestionDTOParser(final QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public InterviewQuestion valueOf(final InterviewQuestionDTO dto) {
        final var type = questionTypeRepository.ofIdentity(dto.getType())
                .orElseThrow(() -> new IllegalArgumentException("Unknown question type: " + dto.getType()));

        return new InterviewQuestionBuilder()
                .with(type, dto.getCotation(), dto.getCotationType(), dto.getBody().toString(), dto.getPossibleAnswers(),
                        dto.getQuestionImporterPlugin()).build();
    }
}