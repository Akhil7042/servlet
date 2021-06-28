package com.sapient.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.contracts.IQuestionDAO;
import com.sapient.dao.QuestionDAO;
import com.sapient.entity.Question;

/**
 * @Author: Akhil
 * 
 */
@WebServlet("/delete-question")
public class DeleteQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String user=    session.getAttribute("user").toString();
//		if(user==null) response.sendRedirect("/WEB-INF/views/login.jsp");
		
		String user = "101";
		
		IQuestionDAO questionDAO  = new QuestionDAO();
		String id = request.getParameter("questionId");
		questionDAO.removeQuestionById(id);
		List<Question> questions = questionDAO.getQuestionByUserId(user);
		request.setAttribute("questions", questions);
		
		  String URI = "WEB-INF/views/user-questions.jsp";
		  request.getRequestDispatcher(URI).forward(request,response);
		
	}

	
}
