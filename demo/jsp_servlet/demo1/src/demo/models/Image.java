package demo.models;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Image implements HttpSessionBindingListener{

	private String _name;
	private int _width;
	private int _height;
		
	public Image(String _name, int _width, int _height) {
		super();
		this._name = _name;
		this._width = _width;
		this._height = _height;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public int get_width() {
		return _width;
	}
	public void set_width(int _width) {
		this._width = _width;
	}
	public int get_height() {
		return _height;
	}
	public void set_height(int _height) {
		this._height = _height;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent e) {
		
		e.getSession().getServletContext().log("image in session " + get_name());
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent e) {
		
		e.getSession().getServletContext().log("image out session" + get_name());
	}
	
}
