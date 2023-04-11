package gis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryIDListDAO {
	private Connection conn;
	
	public LibraryIDListDAO(Connection conn) {
		this.conn=conn;
	}
	
	public List<String> selectByRegion(String regionname) throws SQLException{
		String jsql = "SELECT * FROM tbl_libinfo WHERE region=?";
		PreparedStatement pstmt=null;
		switch (regionname) {
		case "서울특별시경기도인천광역시" :
			jsql= "SELECT * FROM tbl_libinfo WHERE region='서울특별시' OR region='경기도' OR region='인천광역시'";
			pstmt = conn.prepareStatement(jsql);
			break;
		case "대전광역시충청남도충청북도세종특별자치시" :
			jsql= "SELECT * FROM tbl_libinfo WHERE region='대전광역시' OR region='충청남도' OR region='충청북도' OR region='세종특별자치시'";
			pstmt = conn.prepareStatement(jsql);
			break;
		case "대구광역시경상북도" :
			jsql= "SELECT * FROM tbl_libinfo WHERE region='대구광역시' OR region='경상북도'";
			pstmt = conn.prepareStatement(jsql);
			break;
		case "부산광역시울산광역시경상남도" :
			jsql= "SELECT * FROM tbl_libinfo WHERE region='부산광역시' OR region='울산광역시' OR region='경상남도'";
			pstmt = conn.prepareStatement(jsql);
			break;
		case "전라남도전라북도광주광역시" :
			jsql= "SELECT * FROM tbl_libinfo WHERE region='전라북도' OR region='전라남도' OR region='광주광역시'";
			pstmt = conn.prepareStatement(jsql);
			break;
		default:
			jsql= "SELECT * FROM tbl_libinfo WHERE region=?";
			pstmt = conn.prepareStatement(jsql);
			pstmt.setString(1, regionname);
			break;
		}
		
		ResultSet rs = pstmt.executeQuery();
		List<String> listLibid=new ArrayList<String>();
		while(rs.next())
		{
			int intLib_id = rs.getInt( "Lib_id" );
			String strLib_id = Integer.toString(intLib_id);
			listLibid.add(strLib_id);
		}
		return listLibid;
	}
	public List<String> selectByType(String typename) throws SQLException{
		String jsql = "SELECT * FROM tbl_type WHERE type=?";
		PreparedStatement pstmt=null;
		switch (typename) {
		case "공공도서관" :
			jsql= "SELECT * FROM tbl_type WHERE type='공공도서관'";
			pstmt = conn.prepareStatement(jsql);
			break;
		case "작은도서관" :
			jsql= "SELECT * FROM tbl_type WHERE type='작은도서관'";
			pstmt = conn.prepareStatement(jsql);
			break;
		case "어린이도서관" :
			jsql= "SELECT * FROM tbl_type WHERE type='어린이도서관'";
			pstmt = conn.prepareStatement(jsql);
			break;
		case "학교도서관" :
			jsql= "SELECT * FROM tbl_type WHERE type='학교도서관'";
			pstmt = conn.prepareStatement(jsql);
			break;
		case "전문도서관" :
			jsql= "SELECT * FROM tbl_type WHERE type='전문도서관'";
			pstmt = conn.prepareStatement(jsql);
			break;
		default:
			jsql= "SELECT * FROM tbl_type WHERE type=?";
			pstmt = conn.prepareStatement(jsql);
			pstmt.setString(1, typename);
			break;
		}
		
		ResultSet rs = pstmt.executeQuery();
		List<String> listLibid=new ArrayList<String>();
		while(rs.next())
		{
			int intLib_id = rs.getInt( "Lib_id" );
			String strLib_id = Integer.toString(intLib_id);
			listLibid.add(strLib_id);
		}
		return listLibid;
	}
}
	

