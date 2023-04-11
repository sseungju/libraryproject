package gis.action;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import gis.ActionForward;
import gis.IAction;
import gis.dao.LibraryIDListDAO;
import gis.datasource.DBConnection;

public class SelectTypeAction implements IAction {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String typename = request.getParameter("type");
		
		String strResult=null;
		
		Connection conn=null;
		try {
			conn = DBConnection.getInstance();
			
			LibraryIDListDAO libraryIDlistDAO=new LibraryIDListDAO(conn);
			
			List<String> listlib_id = libraryIDlistDAO.selectByType(typename);
			
			Gson gson = new Gson();
			strResult = gson.toJson(listlib_id);
		}finally {
			if(conn!=null)try {conn.close();}catch (Exception e) {}
		}
		
		ActionForward forward = new ActionForward();
		request.setAttribute("output", strResult);
		forward.setPath("/WEB-INF/view/json.jsp");
		
		return forward;
	}
}
