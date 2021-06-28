package com.sapient.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.sapient.contracts.IQuestionDAO;
import com.sapient.entity.Question;
import com.sapient.util.GetConnection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;


/**
 * @Author: Akhil
 * 
 */
public class QuestionDAO implements IQuestionDAO {

	MongoClient mc;
	MongoDatabase qaDB;
	MongoCollection<Question> questionCollection;
	
	  public QuestionDAO() {
		mc= GetConnection.mongoUtilCodecRegistry();
		  qaDB=mc.getDatabase("aarshDBS");
		  questionCollection=qaDB.getCollection("questions",Question.class);
		  
	}

	
	
	
	
	@Override
	public boolean addQuestion(Question question) {
		
		try {
		 	questionCollection.insertOne(question);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public List<Question> getQuestionByUserId(String uId) {
		return questionCollection.find(eq("uId", uId)).into(new ArrayList<Question>());
	}

	@Override
	public Question getQuestionById(String id) {
		
		return  (Question) questionCollection.find(eq("_id", new ObjectId(id))).first();
	
	}

	@Override
	public boolean updateQuestionById(Question question, String id) {
		Bson filter= eq("_id",new ObjectId(id));
		Bson updateOperation= and(Updates.set("content",question.getContent()),
				                 Updates.set("status", question.getStatus())
				               
				);

		UpdateResult updateResult = questionCollection.updateOne(filter, updateOperation);
		
		return updateResult.getModifiedCount()>0;
	}

	@Override
	public boolean removeQuestionById(String id) {
		return questionCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount()>0;
	}

	@Override
	public boolean voteQuestionById(String method, String id) {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public List<Question> getAllQuestions() {
		return questionCollection.find().into(new ArrayList<Question>());
		
	}

}
