package com.onkar.Quiz_service.service;
import com.onkar.Quiz_service.dao.QuizeDao;
import com.onkar.Quiz_service.feing.QuizInterface;
import com.onkar.Quiz_service.model.Quize;
import com.onkar.Quiz_service.model.QusetionWrapper;
import com.onkar.Quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizeServie {

    @Autowired
    QuizeDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuize(String category, int numQ, String title) {

        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quize quize = new Quize();
        quize.setTitle(title);
        quize.setQuestions(questions);
        quizDao.save(quize);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    public ResponseEntity<List<QusetionWrapper>> getQuizQuestions(Integer id) {
           Quize quize = quizDao.getReferenceById(id);
           List<Integer> questionsIds = quize.getQuestionsIds();
           ResponseEntity<List<QusetionWrapper>> questions = quizInterface.getQuestionsFromQuizId(questionsIds);
           return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
           ResponseEntity<Integer> score = quizInterface.getScore(responses);
           return score;
    }
}
