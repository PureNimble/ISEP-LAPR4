/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.questionmanagement.application.viadto;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.money.domain.model.Money;
import eapli.framework.representations.dto.DTOParser;
import lapr4.jobs4u.questionmanagement.domain.Question;
import lapr4.jobs4u.questionmanagement.domain.QuestionBuilder;
import lapr4.jobs4u.questionmanagement.domain.QuestionType;
import lapr4.jobs4u.questionmanagement.dto.QuestionDTO;
import lapr4.jobs4u.questionmanagement.repositories.QuestionTypeRepository;

/**
 * @author Paulo Gandra de Sousa 2021/04/28
 */
public class QuestionDTOParser implements DTOParser<QuestionDTO, Question> {

	private final QuestionTypeRepository questionTypeRepository;

	/**
	 * Configure the parser by injecting the necessary dependency.
	 *
	 * @param dishTypeRepository the dish type repository
	 */
	public QuestionDTOParser(final QuestionTypeRepository questionTypeRepository) {
		this.questionTypeRepository = questionTypeRepository;
	}

    @Override
    public Question valueOf(final QuestionDTO dto) {
        final var type = questionTypeRepository.ofIdentity(dto.getType())
                .orElseThrow(() -> new IllegalArgumentException("Unknown dish type: " + dto.getType()));

        return new QuestionBuilder()
                .withType(type)
                .withBody(dto.getBody().toString())
                .withPossibleAnswers(dto.getPossibleAnswers())
                .build();
    }
}