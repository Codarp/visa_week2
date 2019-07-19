package com.visa.prj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(true);
		ses.setAttribute("life", 5);
		ses.setAttribute("ans", "arraylist");
		ses.setAttribute("word", new StringBuffer("*********"));
		ses.setAttribute("result", "lost");
		response.sendRedirect("game.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(false);
		String w = request.getParameter("char");
		String ans = (String) ses.getAttribute("ans");
		StringBuffer word = (StringBuffer) ses.getAttribute("word");
		int life = (int) ses.getAttribute("life");
			if (ans.contains(w)) {
				for (int i = 0 ; i < ans.length() ; i++) {
					if ( ans.charAt(i) == w.charAt(0) ) {
						word.replace(i, i+1, w);
					}
				}
				if(ans.equals(word.toString())) {
					ses.setAttribute("result", "won");
					response.sendRedirect("endGame.jsp");
				}
			} else {
				life--;
				if (life > 0) {
					ses.setAttribute("life", life);
				} else {
					response.sendRedirect("endGame.jsp");
				}
			}
		response.sendRedirect("game.jsp");
	}

}
