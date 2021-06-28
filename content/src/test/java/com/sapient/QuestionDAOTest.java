package com.sapient;

import static org.junit.Assert.*;

import org.bson.Document;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import com.mongodb.BasicDBObject;
import com.sapient.contracts.IQuestionDAO;
import com.sapient.dao.QuestionDAO;
import com.sapient.entity.Question;
import com.sapient.entity.Votes;
import com.sapient.util.GetConnection;

/**
 * @Author: Akhil
 * 
 */


@TestMethodOrder(OrderAnnotation.class)
public class QuestionDAOTest {

	static IQuestionDAO questionDAO;
	static Question question;
    private String id;
	
	@BeforeAll
	public static void init() {
		questionDAO = new QuestionDAO();
		 question = new Question();
		 question.setUId("105");
         question.setContent("How does this work embedded modified again?" );
        Votes vote = new Votes();
        vote.upvotes = 5;
        vote.downvotes = 5;
         
         question.setStatus("closed");
         
		 
	}
	
	@Test
	@Order(1)
	public void create_question_test() {
		
		assertTrue(questionDAO.addQuestion(question));
		
	    Document document = GetConnection.mongoUtilCodecRegistry()
	    		.getDatabase("aarshDBS")
	    		.getCollection("questions")
	    		.find().sort(new BasicDBObject("_id", -1)).first();
	    id=document.getString("key");
	    		             
	    		
	}
	
	
	@Test
	 @Order(2)
	public void read_question_by_id() {
		assertNotNull(questionDAO.getQuestionById(id));
	}
	
	
	@Test
	 @Order(3)
	public void update_question_by_id() {
		assertEquals(questionDAO.updateQuestionById(question, id), 1);
	}
	
	@Test
	@Order(4)
	public void delete_question_by_id() {
		assertEquals(questionDAO.removeQuestionById(id), 1);
	}
	
}
