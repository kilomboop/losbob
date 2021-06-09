package dam.login.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Persistencias {
	
	private AccesoDB adb;
	
	public Persistencias() {
		adb = new AccesoDB();
	}

	public String getPassword(String id_empleado) {
		String pwd = null;
		String query = "SELECT PASSWORD FROM EMPLEADO WHERE ID = ?";
		Connection con = null;
		PreparedStatement pstmt = null;   
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id_empleado);
			
			rslt = pstmt.executeQuery();
			
			if (rslt.next()) {
				pwd = rslt.getString("PASSWORD");
			} 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return pwd;
	}
	

}
