package demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class helloWorld
 */
//@WebServlet(description = "first jsp", urlPatterns = { "/hello" })
public class helloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadPrameter(request, response, "doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadPrameter(request, response, "doPost");
	}
	
	private void loadPrameter(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException
	{
		String sUserName = request.getParameter("username");
		String sPassword = request.getParameter("password");
		
		PrintWriter writer = response.getWriter();
		writer.println("</br>" +  "load parmeter" + method);
		writer.println("</br>");
		writer.println("username: " + sUserName + " , password: " + sPassword );
		writer.println("</br>");
		
		
		ServletConfig config = this.getServletConfig();
		String song = config.getInitParameter("song");
		writer.println("this song is: " + song);
		writer.println("</br>");
		
		
		ServletContext context = this.getServletContext();
		//ServletContext context = this.getServletConfig().getServletContext();
		String scs = context.getInitParameter("connection_str");
		
		writer.println("connection string: " + scs);
		writer.println("</br>");
	}

}
