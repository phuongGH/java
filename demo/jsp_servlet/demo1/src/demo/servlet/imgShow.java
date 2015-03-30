package demo.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import demo.models.student;

/**
 * Servlet implementation class imgShow
 */
@WebServlet("/imgShow")
public class imgShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imgShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCheck(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCheck(request, response);
		
	}

	private void doCheck(HttpServletRequest request,
		HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("username");
		//session.invalidate();
		if(userName == null){
			response.sendRedirect("login.jsp");
		}
		else {
			this.getServletContext().setAttribute("scope1", "scope application");
			session.setAttribute("scope2", "scope session");
			request.setAttribute("scope1", "scope request");
			student student =  new student();
			student.setName("aaaaaaaaaaaaaaaa");
			request.setAttribute("student",student);
			java.util.List<String> lang = new ArrayList<String>();
			lang.add("Java");
			lang.add("C#");
			lang.add("html");
			request.setAttribute("languages", lang);
			
			RequestDispatcher dispatcher =  request.getRequestDispatcher("show2.jsp");
			dispatcher.forward(request, response);
			for(Cookie c: request.getCookies())
			{
				System.out.println(c.getName());
				System.out.println(c.getValue());
				System.out.println();
			}
		}
	}

}
