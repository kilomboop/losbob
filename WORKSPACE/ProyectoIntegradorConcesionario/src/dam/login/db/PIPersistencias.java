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

			int id;
			String marca;
			String modelo;
			String color;
			int anio;
			String extras;
			String combustible;
			int precio;
			String transmision;
			
			while (rslt.next()) {
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				precio = rslt.getInt(7);
				anio = rslt.getInt(8);
				color = rslt.getString(4);
				combustible = rslt.getString(5);
				transmision = rslt.getString(6);
				extras = rslt.getString(9);
				id = rslt.getInt(1);

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

	public int deleteCoche(String numCoche) {
		String query = "DELETE FROM COCHE WHERE MARCA = ?";
		int res = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, numCoche);
			
			res = pstmt.executeUpdate();
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

	public int insertCoche(Coche coche) {
		String query = "INSERT INTO COCHE (ID_COCHE, MARCA, MODELO, COLOR, PRECIO, ANIO, COMBUSTIBLE, TRANSMISION, EXTRAS) " 
				+ "VALUES(?,?,?,?,?,?,?,?,?)";

		Connection con = null;
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			con = adb.getConexion();

			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, coche.getId());
			pstmt.setString(7, coche.getCombustible());
			pstmt.setString(2, coche.getMarca());
			pstmt.setString(3, coche.getModelo());
			pstmt.setInt(5, coche.getPrecio());
		    pstmt.setInt(6, coche.getAnio());
			pstmt.setString(4, coche.getColor());
			pstmt.setString(8, coche.getTransmision());
			pstmt.setString(9, coche.getExtras());


			res = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			res = -1;
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return res;
	}

	public ArrayList<String> selectDistinctCombustible() {
		ArrayList<String> listaCombustible = new ArrayList<String>();
		String query = "SELECT DISTINCT COMBUSTIBLE FROM COCHE";
		
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
				
				listaCombustible.add(nac);
				
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
		
		return listaCombustible;
	}

	public ArrayList<String> selectDistinctTransmision() {
		ArrayList<String> listaTransmision = new ArrayList<String>();
		String query = "SELECT DISTINCT TRANSMISION FROM COCHE";
		
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
				
				listaTransmision.add(nac);
				
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
		
		return listaTransmision;
	}

	public ArrayList<Coche> selectCoche(int precioFiltro) {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		String query = "SELECT ID_COCHE, MARCA, MODELO, COLOR, COMBUSTIBLE, TRANSMISION, PRECIO, ANIO, EXTRAS FROM COCHE"
				+ " WHERE PRECIO < ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
		
			pstmt.setInt(1, precioFiltro);

			
			rslt = pstmt.executeQuery();
			
			int id;
			String marca;
			String modelo;
			String color;
			int anio;
			String extras;
			String combustible;
			int precio;
			String transmision;
			
			while (rslt.next()) {
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				precio = rslt.getInt(7);
				anio = rslt.getInt(8);
				color = rslt.getString(4);
				combustible = rslt.getString(5);
				transmision = rslt.getString(6);
				extras = rslt.getString(9);
				id = rslt.getInt(1);

				listaCoches.add(new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision));
				
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
		
		return listaCoches;
	}

	public ArrayList<Coche> selectCoche(String colorFiltro, String transmisionFiltro, String combustibleFiltro,
			int precioFiltro) {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		String query = "SELECT ID_COCHE, MARCA, MODELO, COLOR, COMBUSTIBLE, TRANSMISION, PRECIO, ANIO, EXTRAS FROM COCHE"
				+ " WHERE PRECIO <= ? AND COLOR = ? AND TRANSMISION = ? AND COMBUSTIBLE = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
		
			pstmt.setInt(1, precioFiltro);
			pstmt.setString(2, colorFiltro);
			pstmt.setString(3, transmisionFiltro);
			pstmt.setString(4, combustibleFiltro);

			
			rslt = pstmt.executeQuery();
			
			int id;
			String marca;
			String modelo;
			String color;
			int anio;
			String extras;
			String combustible;
			int precio;
			String transmision;
			
			while (rslt.next()) {
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				precio = rslt.getInt(7);
				anio = rslt.getInt(8);
				color = rslt.getString(4);
				combustible = rslt.getString(5);
				transmision = rslt.getString(6);
				extras = rslt.getString(9);
				id = rslt.getInt(1);

				listaCoches.add(new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision));
				
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
		
		return listaCoches;
	}

	public ArrayList<Coche> selectCoche(String colorFiltro, int precioFiltro) {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		String query = "SELECT ID_COCHE, MARCA, MODELO, COLOR, COMBUSTIBLE, TRANSMISION, PRECIO, ANIO, EXTRAS FROM COCHE"
				+ " WHERE PRECIO <= ? AND COLOR = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
		
			pstmt.setInt(1, precioFiltro);
			pstmt.setString(2, colorFiltro);

			
			rslt = pstmt.executeQuery();
			
			int id;
			String marca;
			String modelo;
			String color;
			int anio;
			String extras;
			String combustible;
			int precio;
			String transmision;
			
			while (rslt.next()) {
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				precio = rslt.getInt(7);
				anio = rslt.getInt(8);
				color = rslt.getString(4);
				combustible = rslt.getString(5);
				transmision = rslt.getString(6);
				extras = rslt.getString(9);
				id = rslt.getInt(1);

				listaCoches.add(new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision));
				
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
		
		return listaCoches;
	}

	public ArrayList<Coche> selectCoche2(String transmisionFiltro, int precioFiltro) {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		String query = "SELECT ID_COCHE, MARCA, MODELO, COLOR, COMBUSTIBLE, TRANSMISION, PRECIO, ANIO, EXTRAS FROM COCHE"
				+ " WHERE PRECIO <= ? AND TRANSMISION = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
		
			pstmt.setInt(1, precioFiltro);
			pstmt.setString(2, transmisionFiltro);

			
			rslt = pstmt.executeQuery();
			
			int id;
			String marca;
			String modelo;
			String color;
			int anio;
			String extras;
			String combustible;
			int precio;
			String transmision;
			
			while (rslt.next()) {
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				precio = rslt.getInt(7);
				anio = rslt.getInt(8);
				color = rslt.getString(4);
				combustible = rslt.getString(5);
				transmision = rslt.getString(6);
				extras = rslt.getString(9);
				id = rslt.getInt(1);

				listaCoches.add(new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision));
				
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
		
		return listaCoches;
	}

	public ArrayList<Coche> selectCoche3(String combustibleFiltro, int precioFiltro) {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		String query = "SELECT ID_COCHE, MARCA, MODELO, COLOR, COMBUSTIBLE, TRANSMISION, PRECIO, ANIO, EXTRAS FROM COCHE"
				+ " WHERE PRECIO <= ? AND COMBUSTIBLE = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
		
			pstmt.setInt(1, precioFiltro);
			pstmt.setString(2, combustibleFiltro);

			
			rslt = pstmt.executeQuery();
			
			int id;
			String marca;
			String modelo;
			String color;
			int anio;
			String extras;
			String combustible;
			int precio;
			String transmision;
			
			while (rslt.next()) {
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				precio = rslt.getInt(7);
				anio = rslt.getInt(8);
				color = rslt.getString(4);
				combustible = rslt.getString(5);
				transmision = rslt.getString(6);
				extras = rslt.getString(9);
				id = rslt.getInt(1);

				listaCoches.add(new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision));
				
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
		
		return listaCoches;
	}

	public ArrayList<Coche> selectCoche(String colorFiltro, String transmisionFiltro, int precioFiltro) {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		String query = "SELECT ID_COCHE, MARCA, MODELO, COLOR, COMBUSTIBLE, TRANSMISION, PRECIO, ANIO, EXTRAS FROM COCHE"
				+ " WHERE PRECIO <= ? AND COLOR = ? AND TRANSMISION = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
		
			pstmt.setInt(1, precioFiltro);
			pstmt.setString(2, colorFiltro);
			pstmt.setString(3, transmisionFiltro);

			
			rslt = pstmt.executeQuery();
			
			int id;
			String marca;
			String modelo;
			String color;
			int anio;
			String extras;
			String combustible;
			int precio;
			String transmision;
			
			while (rslt.next()) {
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				precio = rslt.getInt(7);
				anio = rslt.getInt(8);
				color = rslt.getString(4);
				combustible = rslt.getString(5);
				transmision = rslt.getString(6);
				extras = rslt.getString(9);
				id = rslt.getInt(1);

				listaCoches.add(new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision));
				
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
		
		return listaCoches;
	}

	public ArrayList<Coche> selectCoche2(String colorFiltro, String combustibleFiltro, int precioFiltro) {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		String query = "SELECT ID_COCHE, MARCA, MODELO, COLOR, COMBUSTIBLE, TRANSMISION, PRECIO, ANIO, EXTRAS FROM COCHE"
				+ " WHERE PRECIO <= ? AND COLOR = ? AND COMBUSTIBLE = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
		
			pstmt.setInt(1, precioFiltro);
			pstmt.setString(2, colorFiltro);
			pstmt.setString(3, combustibleFiltro);

			
			rslt = pstmt.executeQuery();
			
			int id;
			String marca;
			String modelo;
			String color;
			int anio;
			String extras;
			String combustible;
			int precio;
			String transmision;
			
			while (rslt.next()) {
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				precio = rslt.getInt(7);
				anio = rslt.getInt(8);
				color = rslt.getString(4);
				combustible = rslt.getString(5);
				transmision = rslt.getString(6);
				extras = rslt.getString(9);
				id = rslt.getInt(1);

				listaCoches.add(new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision));
				
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
		
		return listaCoches;
	}

	public ArrayList<Coche> selectCoche3(String combustibleFiltro, String transmisionFiltro, int precioFiltro) {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		String query = "SELECT ID_COCHE, MARCA, MODELO, COLOR, COMBUSTIBLE, TRANSMISION, PRECIO, ANIO, EXTRAS FROM COCHE"
				+ " WHERE PRECIO <= ? AND TRANSMISION = ? AND COMBUSTIBLE = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
		
			pstmt.setInt(1, precioFiltro);
			pstmt.setString(2, transmisionFiltro);
			pstmt.setString(3, combustibleFiltro);

			
			rslt = pstmt.executeQuery();
			
			int id;
			String marca;
			String modelo;
			String color;
			int anio;
			String extras;
			String combustible;
			int precio;
			String transmision;
			
			while (rslt.next()) {
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				precio = rslt.getInt(7);
				anio = rslt.getInt(8);
				color = rslt.getString(4);
				combustible = rslt.getString(5);
				transmision = rslt.getString(6);
				extras = rslt.getString(9);
				id = rslt.getInt(1);

				listaCoches.add(new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision));
				
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
		
		return listaCoches;
	}

}
