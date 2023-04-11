package gis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gis.ActionForward;
import gis.CommandFactory;
import gis.IAction;

/**
 * Servlet implementation class LibraryController
 */
@WebServlet("/Library.do")
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		IAction action=null;
		ActionForward forward=null;
		request.setCharacterEncoding("utf-8");
		try {
			CommandFactory commandFactory=CommandFactory.getInstance();
			
			String strAction = (String)request.getParameter("action");
			if( (strAction==null) || (strAction.equals("")) )
			{
				strAction="DefaultLibrary";
			}
			
			action=commandFactory.getAction(strAction);
			forward=action.execute(request, response);
			
		}catch(Exception ex)
		{
			throw new ServletException(ex.getMessage());
		}
		
		if(forward.isRedirect()){
			response.sendRedirect(forward.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
			rd.forward(request, response);
		}
		
	}

}
