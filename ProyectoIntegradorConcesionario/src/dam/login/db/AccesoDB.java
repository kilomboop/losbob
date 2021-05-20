package dam.login.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AccesoDB {
	
	static final String DRIVER = "org.sqlite.JDBC";
	static final String URL = "jdbc:sqlite:dbSQLite/ProyectoIntegrador.db";
	
	private String driver;
	private String url;
	
	public AccesoDB() {
		driver = DRIVER;
		url = URL;
	}
	public Connection getConexion() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		System.out.println("Conexión establecida con la BBDD");
		return con;
	}
	
}
