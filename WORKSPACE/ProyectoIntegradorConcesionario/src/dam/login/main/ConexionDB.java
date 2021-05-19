package dam.login.main;

import java.sql.SQLException;

import dam.login.db.AccesoDB;

public class ConexionDB {

	public static void main(String[] args) {
		AccesoDB adb = new AccesoDB();
		
		try {
			adb.getConexion();
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el DRIVER");
		}catch (SQLException e) {
			System.out.println("Error en la URL");
		}

	}

}
