package demo.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class newListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		
		e.getSession().getServletContext().log("new session ");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		
		e.getSession().getServletContext().log("Destroy session " );
	}

}
