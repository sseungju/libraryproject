package gis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
