package demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.models.DatabaseManagement;
import demo.models.Image;


public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Authentication() {
        super();
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<br>" +  "doPost");
		
		String sUserName = request.getParameter("username");
		String sPassword = request.getParameter("password");
		writer.println("username: " + sUserName + " , password: " + sPassword );
		
		DatabaseManagement dbm = new DatabaseManagement();
		if(dbm.checkUser(sUserName, sPassword)){
		
			
			Cookie cokie = new Cookie("loation", "Viet Nam");
			response.addCookie(cokie);
			HttpSession session = request.getSession();
			RequestDispatcher dispatcher =  request.getRequestDispatcher("/imgShow");
			Image img = new Image("img1", 350, 350);
			request.setAttribute("imageName", img);
			session.setAttribute("imageName2", new Image("img1", 350, 350));
			session.removeAttribute("imageName2");
			//session.setMaxInactiveInterval(900);
			session.setAttribute("username", sUserName);
			dispatcher.forward(request, response);
			//writer.println("welcome " + sUserName + " to website");
		}
		else {
			response.sendRedirect("login.jsp");
			//writer.println("username or password is incorrect.");
		}
		
	}


}
