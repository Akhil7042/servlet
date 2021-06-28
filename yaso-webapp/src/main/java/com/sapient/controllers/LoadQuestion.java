package com.sapient.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.contracts.IQuestionDAO;
import com.sapient.dao.QuestionDAO;
import com.sapient.entity.Question;

/**
 * Servlet implementation class LoadQuestion
 */

@WebServlet("/load-question")
public class LoadQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @Author: Akhil
	 * 
	 */
    public LoadQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String qId = request.getParameter("questionId").toString();

		
		
		IQuestionDAO questionDAO = new QuestionDAO();
		Question question=  questionDAO.getQuestionById(qId);
		
		request.setAttribute("content", question.getContent());
		request.setAttribute("status", question.getStatus());
		request.setAttribute("questionId", qId);
		
		 String URI = "WEB-INF/views/update-question.jsp";
	     request.getRequestDispatcher(URI).forward(request,response);
		
		
	}

	

}
