package com.tywdi.backend.controller;


import com.tywdi.backend.model.dto.QuestionAnswerDTO;
import com.tywdi.backend.service.QaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Organisation: Codemerger Ldt.
 * Project: qa
 * Package: com.twentytwenty.qa.controller
 * Date: 08.08.2020
 *
 * @author: Michael Bielang, b137ang@codemerger.com.
 * @version: java version "14" 2020-03-17
 */

@RestController
public final class QaController implements QaControllerInterface {

    @Autowired
    private QaService qaService;

    @Override
    @GetMapping(value = "/questions")
    public Iterable<QuestionAnswerDTO> getQuestions() {
        return qaService.getQaList();
    }

    @Override
    @GetMapping(value = "/question")
    public QuestionAnswerDTO getQuestion(@RequestParam("id") final String id) {
        return qaService.getQuestion(id);
    }

    @Override
    @PostMapping(value = "/question")
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionAnswerDTO addNewQa(@RequestBody @Valid final QuestionAnswerDTO questionAnswerDTO) {
        return qaService.addQa(questionAnswerDTO.getAnswer(), questionAnswerDTO.getQuestion(), questionAnswerDTO.getCategory());
    }

    @Override
    @PutMapping(value = "question/{id}")
    public QuestionAnswerDTO updateQuestion(@RequestBody @Valid final QuestionAnswerDTO updatedQA, @PathVariable final String id) {
        return qaService.updateQuestion(updatedQA, id);
    }
}
