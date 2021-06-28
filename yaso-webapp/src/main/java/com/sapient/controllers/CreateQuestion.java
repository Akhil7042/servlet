package com.sapient.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sapient.beansCreator.QuestionCreator;
import com.sapient.contracts.IQuestionDAO;
import com.sapient.dao.QuestionDAO;
import com.sapient.entity.Question;

/**
 * @Author: Akhil
 * 
 */
@WebServlet("/create-question")
public class CreateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
//		request.setAttribute("userId", "108");
		IQuestionDAO questionDAO = new QuestionDAO();
		Question question = QuestionCreator.questionCreator(request);
		questionDAO.addQuestion(question);
		
		 String URI = "index.jsp";
	     request.getRequestDispatcher(URI).forward(request,response);
		
	}

	

}
