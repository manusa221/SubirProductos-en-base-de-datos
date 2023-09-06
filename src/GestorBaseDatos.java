import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GestorBaseDatos {

	protected String servidor;
	protected String puerto;
	protected String nombreBaseDatos;
	protected String usuario;
	protected String password;
	protected Connection conexion = null;// creo un parametro de connection por si lo tengo que utilizar en cualquier
											// metodo//
	protected Statement peticion;
	protected ResultSet resultados;
	protected String nombre;
	protected int id;
	protected int cantidad;
	protected float precio;

	public GestorBaseDatos() {// constructor//

		this.servidor = "localhost";
		this.puerto = "3306";
		this.nombreBaseDatos = "tienda";
		this.usuario = "root";
		this.password = "";
		
	}

	// sobrecarga del constructor//

	public GestorBaseDatos(String servidor, String puerto, String nombreBD, String user, String pass) {// constructor//

		this.servidor = servidor;
		this.puerto = puerto;
		this.nombreBaseDatos = nombreBD;
		this.usuario = user;
		this.password = pass;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getNombreBaseDatos() {
		return nombreBaseDatos;
	}

	public void setNombreBaseDatos(String nombreBaseDatos) {
		this.nombreBaseDatos = nombreBaseDatos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// creo un metodo para conectar la base de datos//

	public boolean conectar() {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + this.servidor + ":" + this.puerto + "/" + this.nombreBaseDatos, this.usuario,
					this.password);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<producto> ListarProducto()
	{// en el CRUD esto seria el read//
		ArrayList<producto> productos = new ArrayList<producto>();
		if (conexion != null)
		{

			try {
				peticion = (Statement) conexion.createStatement();
			    resultados = (ResultSet) peticion.executeQuery("SELECT * FROM productos");

				while (resultados.next()) {
					producto p = new producto();
					p.setId(resultados.getInt("id"));// introduzco el id en p//
					p.setNombre(resultados.getString("nombre"));// introduzco el nombre en p//
					p.setPrecio(resultados.getFloat("precio"));
					p.setCantidad(resultados.getInt("cantidad"));
					
					productos.add(p);// metemos toda la informacion dentro del array//

					//System.out.println(resultados.getString("login") + " - " + resultados.getString("pass"));
				}
				resultados.close();
				peticion.close();
				
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			}	
		 else
		{
			return null;
		}
		return productos;
	}

//voy hacer un metodo para obtener la información de la base de datos.obtener usuarios// 
	// creo un arrayList dinamico//
	public ArrayList<usuario> getusers()
	{// en el CRUD esto seria el read//
		ArrayList<usuario> usuarios = new ArrayList<usuario>();
		if (conexion != null)
		{

			try {
				peticion = (Statement) conexion.createStatement();
			    resultados = (ResultSet) peticion.executeQuery("SELECT * FROM users");

				while (resultados.next()) {
					usuario u = new usuario();
					u.setUsuario(resultados.getString("login"));// introduzco el login en u//
					u.setPassword(resultados.getString("pass"));// introduzco el pass en u//
					usuarios.add(u);// metemos toda la informacion dentro del array//

					System.out.println(resultados.getString("login") + " - " + resultados.getString("pass"));
				}
				resultados.close();
				peticion.close();
				
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			}	
		 else 
		{
			return null;
		}
		return usuarios;
	}

	public int CrearUsuarios(String usuario, String pass) throws SQLException
	{
	
		if(conexion !=null)
	{
		
	try {
		peticion = (Statement) conexion.createStatement();
		return peticion.executeUpdate("INSERT INTO users (login,pass) VALUES ('"+usuario+"', '"+pass+"')");
	}catch(SQLException e){
		e.printStackTrace();
	}
		
	}
	return 0;
}
	
	
	public int CrearProducto( String nombre,float precio, int cantidad) throws SQLException {
		
		if(conexion !=null)
		{
			try {
			peticion = (Statement) conexion.createStatement();
			return peticion.executeUpdate ("INSERT INTO productos (nombre, precio, cantidad) VALUES ('"+nombre+" ',' "+precio+" ',' "+cantidad+"')");	
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		}
		return 0;
	}
	


public int BorrarProducto(int id) throws SQLException {
	
	
		try {
			peticion = (Statement) conexion.createStatement();
		
			return peticion.executeUpdate("DELETE FROM   productos   WHERE id="+id );
			
		} catch (Exception e) {
			
		} finally {
			if (peticion != null) {
				peticion.close();
			}
		}
		
		return 0;
		
}
public void eliminarFila(int id) throws SQLException {

	try {
		peticion = (Statement) conexion.createStatement();
		String sql = "DELETE FROM 'productos'  WHERE "+id+" ";
		peticion.executeUpdate(sql);
		System.out.println("Fila eliminada correctamente");
	} catch (Exception e) {
		System.out.println("No existe esta fila , por favor introduzca otro id.  ");
	} finally {
		if (peticion != null) {
			peticion.close();
		}
	}
}

public int ModificarProducto(int id, String nombre, float precio, int cantidad) throws SQLException {
	
	
	
	
	try {
		peticion = (Statement) conexion.createStatement();
		return peticion.executeUpdate( "UPDATE productos SET id='"+id+"' ,nombre='"+nombre+"', precio='"+precio+"' , cantidad='"+cantidad+"'   WHERE id="+id);
		
		
		

	} catch (Exception e) {
		

	} finally {

		if (peticion != null) {
			peticion.close();
		}
	}
	return 0;
}

}

		

		
		
