package dam.pic.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class VerifyUser {

	private AccesoBD adb;

	public VerifyUser() {
		adb = new AccesoBD();
	}

	public ArrayList<Coche> selectCoches() {
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		try {
			con = adb.getConexion();

			stmt = con.createStatement();
			String query = "SELECT NUMERO, NOMBRE, EDAD, NACIONALIDAD, ESCUDERIA FROM PILOTOS";
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
				id = rslt.getString(1);
				marca = rslt.getString(2);
				modelo= rslt.getString(3);
				color = rslt.getString(4);
				anio = rslt.getString(5);
				extras = rslt.getString(6);
				combustible = rslt.getString(7);
				precio = rslt.getInt(8);
				transmision = rslt.getString(9);

				listaCoches.add(new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision));

			}

		} catch (ClassNotFoundException e) {
			System.out.println("Problemas con el driver");
		} catch (SQLException e) {
			System.out.println("Problemas con BBDD");
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

}

	

	