package com.sapient;

import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sapient.contracts.IAnswerDAO;
import com.sapient.contracts.IQuestionDAO;
import com.sapient.dao.AnswerService;
import com.sapient.dao.QuestionDAO;
import com.sapient.entity.Answer;
import com.sapient.entity.Question;
import com.sapient.entity.Votes;
import com.sapient.util.GetConnection;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
//        MongoClient client = GetConnection.mongoUtilCodecRegistry();
//        MongoDatabase db = client.getDatabase("aarshDBS");
//        MongoCollection<Answer> questionMongoCollection = GetConnection.getCollectionFromDatabase("aarshDBS", "answers", Answer.class);
//       IQuestionDAO questionDAO=new QuestionDAO();
//    	Question question  =  new Question();
//         question.setUId("101");
//         question.setContent("Hello world" );
//        
//        
//         question.setStatus("open");
    	
    	IAnswerDAO answerDAO = new AnswerService();
         
        Answer answer = new Answer(); 
    	answer.setId(new ObjectId());
        answer.setContent("test answer2");
        answer.setUId("101");
        answer.setQuestionId(new ObjectId("60d7700531c9d3a41ebad653"));
        
        System.out.println(answerDAO.addAnswer(answer));
        

    }
}