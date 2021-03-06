package com.tywdi.backend.service;

import com.tywdi.backend.model.dto.QuestionAnswerDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * Organisation: Codemerger Ldt.
 * Project: backend
 * Package: com.tywdi.backend.service
 * Date: 15.09.2020
 *
 * @author: Michael Bielang, b137ang@codemerger.com.
 * @version: java version "14" 2020-03-17
 */
public interface QaServiceInterface {
    @Transactional
    QuestionAnswerDTO addQa(String answer, String question, QuestionAnswerDTO.Category category);

    Iterable<QuestionAnswerDTO> getQaList();

    QuestionAnswerDTO getQuestion(String id);

    @Transactional
    QuestionAnswerDTO updateQuestion(QuestionAnswerDTO updatedQAV, String id);
}
