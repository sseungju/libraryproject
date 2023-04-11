package gis.action;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gis.ActionForward;
import gis.IAction;
import gis.dao.LibraryInfoDAO;
import gis.datasource.DBConnection;
import gis.vo.LibraryInfo;

public class SelectLibraryAction implements IAction {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strKey = request.getParameter("lib_id");
		
		int intLibid =Integer.parseInt(strKey);
		
		Connection conn = null;
		LibraryInfo libraryinfo =null;
		try {
			conn = DBConnection.getInstance();
			LibraryInfoDAO libraryInfoDAO = new LibraryInfoDAO(conn);
			libraryinfo = libraryInfoDAO.selectByID(intLibid);
		}finally {
			if(conn!=null)try{conn.close();}catch (Exception e) {}
		}
		
		ActionForward forward=new ActionForward();
		request.setAttribute("LibraryInfo", libraryinfo);
		
		forward.setPath("/WEB-INF/view/informationWindow.jsp");
		
		return forward;
	}

}
