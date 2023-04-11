package gis.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gis.ActionForward;
import gis.IAction;

public class DefaultLibraryAction implements IAction {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		forward.setPath("/WEB-INF/view/index.jsp");
		
		return forward;
	}
}
