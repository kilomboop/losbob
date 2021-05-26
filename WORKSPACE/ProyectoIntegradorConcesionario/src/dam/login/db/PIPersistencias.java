package dam.login.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dam.pic.model.Coche;



public class PIPersistencias {
	
	private AccesoDB adb;
	
	public PIPersistencias() {
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
	
	public ArrayList<Coche> selectCoches() {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		try {
			con = adb.getConexion();

			stmt = con.createStatement();
			String query = "SELECT ID_COCHE, MARCA, MODELO, COLOR, COMBUSTIBLE, TRANSMISION, PRECIO, ANIO, EXTRAS FROM COCHE";
			rslt = stmt.executeQuery(query);

			String id;
			String marca;
			String modelo;
			String color;
			String anio;
			String extras;
			String combustible;
			int precio;
			String transmision;
			
			while (rslt.next()) {
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				precio = rslt.getInt(7);
				anio = rslt.getString(8);
				color = rslt.getString(4);
				combustible = rslt.getString(5);
				transmision = rslt.getString(6);
				extras = rslt.getString(9);
				id = rslt.getString(1);

				listaCoches.add(new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision));

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null)
					rslt.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listaCoches;
	}
	
	public ArrayList<String> selectDistinctColor() {
		ArrayList<String> listaColores = new ArrayList<String>();
		String query = "SELECT DISTINCT COLOR FROM COCHE";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		try {
			con = adb.getConexion();
			
			stmt = con.createStatement();
			
			rslt = stmt.executeQuery(query);
			
			String nac;
			while (rslt.next()) {
				nac = rslt.getString(1);
				
				listaColores.add(nac);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaColores;
	}

}