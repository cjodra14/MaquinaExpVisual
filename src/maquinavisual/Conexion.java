package maquinavisual;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

public class Conexion {
	Connection c=null;
	Statement sentencia=null;
	String nombreTabla;
	String Nombre;
	float saldo;
	ArrayList<Usuarios> users=new ArrayList();
	
	
	public void conectar() {
	
	try {
		Class.forName("org.sqlite.JDBC");
		c=DriverManager.getConnection("jdbc:sqlite:test.db");
		System.out.println("Exito al conectar con la base de datos");
	}catch(Exception e) {
		System.out.println("Hay un error en la conexión con la base de datos");
	}
	}
	public void crearTabla(String nombreTabla) throws SQLException {
		this.nombreTabla=nombreTabla;
		try {
			sentencia=c.createStatement();
			String sql="CREATE TABLE "+nombreTabla+"(Nombre TEXT NOT NULL, Saldo FLOAT NOT NULL)";
			sentencia.execute(sql);
			sentencia.close();
			c.close(); 
			System.out.println("Exito al crear la tabla");						
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Error al crear la tabla o la tabla ya existe");
		}				
		
	}
	public void insertarDatos(String Nombre, String nombreTabla) {
		this.Nombre=Nombre;
		this.nombreTabla=nombreTabla;
		String sqlInsert="INSERT INTO "+nombreTabla+" (Nombre, Saldo) "+ "VALUES ('"+Nombre+"', 0.0)";
		try {
			conectar();
			sentencia=c.createStatement();
			sentencia.executeUpdate(sqlInsert);
			sentencia.close();
			c.close();			
			System.out.println("Datos insertados con exito");
		}catch(Exception e) {
			System.out.println("Error al introducir el dato en la tabla");
			e.printStackTrace();
		}
	}
	public ArrayList<Usuarios> consultaDatos(String nombreTabla) throws SQLException {
		
		conectar();
		sentencia=c.createStatement();
		String consultaSQL="SELECT rowid, Nombre, saldo FROM "+nombreTabla;
		try {
			ResultSet rs= sentencia.executeQuery(consultaSQL);
			while(rs.next()) {
				Usuarios nuevoUser=new Usuarios();
				nuevoUser.setRowid(rs.getInt("rowid"));
				nuevoUser.setNombre(rs.getString("Nombre"));
				nuevoUser.setSaldo(rs.getFloat("Saldo"));
				users.add(nuevoUser);
				
			}
			rs.close();
			sentencia.close();
			c.close();
		}catch(Exception e) {
			System.out.println("Fallo al hacer la consulta");
		}
		return users;
	}

}
