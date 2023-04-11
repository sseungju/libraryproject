package gis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gis.vo.LibraryInfo;

public class LibraryInfoDAO {
	private Connection conn;
	
	public LibraryInfoDAO(Connection conn) {
		this.conn=conn;
	}
	public LibraryInfo selectByID(int libid) throws SQLException{
		String jsql = "SELECT * FROM ((tbl_libinfo INNER JOIN tbl_data USING (lib_id)) INNER JOIN tbl_type USING(lib_id)) INNER JOIN tbl_seat USING (lib_id) WHERE lib_id=?";
		PreparedStatement pstmt = conn.prepareStatement(jsql);
		pstmt.setInt(1,libid);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		String name = rs.getString("name");
		String region = rs.getString("region");
		String address = rs.getString("address");
		String phone = rs.getString("phone");
		String closed = rs.getString("closed");
		String libraryone = rs.getString("libraryone");
		int borrowbook = rs.getInt("borrowbook");
		int borrowdate = rs.getInt("borrowdate");
		String type = rs.getString("type");
		int seat = rs.getInt("seat");
		
		LibraryInfo libraryinfo = new LibraryInfo(name, region, address, phone,closed, libraryone, borrowbook, borrowdate, type, seat);
		return libraryinfo;
		
	}
}
