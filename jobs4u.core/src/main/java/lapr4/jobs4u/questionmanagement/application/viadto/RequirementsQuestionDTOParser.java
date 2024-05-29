package lapr4.jobs4u.questionmanagement.application.viadto;

import eapli.framework.representations.dto.DTOParser;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestionBuilder;
import lapr4.jobs4u.questionmanagement.dto.RequirementsQuestionDTO;

/**
 * @author 2DI2
 */
public class RequirementsQuestionDTOParser implements DTOParser<RequirementsQuestionDTO, RequirementsQuestion> {

    @Override
    public RequirementsQuestion valueOf(final RequirementsQuestionDTO dto) {
        return new RequirementsQuestionBuilder()
                .with(dto.getBody().toString(), dto.getPossibleAnswers(), dto.getMinimumRequirement(),
                        dto.getQuestionImporterPlugin())
                .build();
    }
}