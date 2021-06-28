package com.sapient.contracts;

import com.sapient.entity.Question;

import java.util.List;

/**
 * @Author: Aarsh Verdhan
 * @See: Interface for question Business Logic from MongoDB
 */

public interface IQuestionDAO {
    // to add questions
    boolean addQuestion(Question question);
    
    
    //get all questions from DB
    
    List<Question> getAllQuestions();

    // get questions by userId
    List<Question> getQuestionByUserId(String uId);

    // get questions by questionId
    Question getQuestionById(String id);

    // update
    boolean updateQuestionById(Question question, String id);

    // remove
    boolean removeQuestionById(String id);

    // to upvote/downvote questions

    boolean voteQuestionById(String method, String id);


}
