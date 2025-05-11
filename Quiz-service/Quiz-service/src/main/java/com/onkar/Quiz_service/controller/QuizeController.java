package com.onkar.Quiz_service.controller;
import com.onkar.Quiz_service.model.QuizDto;
import com.onkar.Quiz_service.model.QusetionWrapper;
import com.onkar.Quiz_service.model.Response;
import com.onkar.Quiz_service.service.QuizeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizeController  {

    @Autowired
    QuizeServie quizServie;

    @PostMapping("create")
    public ResponseEntity<String> createQuize(@RequestBody QuizDto quizDto){
            return quizServie.createQuize(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QusetionWrapper>> getQuizeQuestion(@PathVariable Integer id){
            return quizServie.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
         return quizServie.calculateResult(id,responses);
    }
}
