import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {

public static void main(String[] args) throws SQLException {
int i=0;
Scanner sc = new Scanner(System.in);
String opcion;
String nombre;
int id,cantidad;
float precio;
GestorBaseDatos gbd = new GestorBaseDatos();
ArrayList <producto> productos = new ArrayList<producto>();



if(gbd.conectar())
{
	
	System.out.println("Se ha conectado correctamente");
	
}
	else {
		System.out.println("No se ha podido conectar");
	}




do {

	System.out.println("************************************************************************");
	System.out.println("\n************************GESTOR DE PRODUCTOS*****************************");
	
	System.out.println("Seleccione una opción del menú:");
	System.out.println("1): Crear un producto ");
	System.out.println("2): Listar todos los productos ");
	System.out.println("3): Modificar un producto ");
	System.out.println("4): Borrar un producto ");
	System.out.println("0): Salir del programa");
	
	System.out.print("\nOpción_");
	opcion = sc.next();

	if (!opcion.equals("0") && !opcion.equals("1")  && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("4")) 
	{
		System.out.println(" Opción erronea ");
	}
		
	
		if(opcion.equals("1"))
		{
			
			System.out.println(" Introduzca el nombre del producto ");
			nombre = sc.next(); 
			System.out.println(" Introduzca el precio unitario del producto ");
			sc.nextLine();
			precio = sc.nextFloat(); 
			System.out.println(" Introduzca la cantidad del producto ");
			cantidad= sc.nextInt();
			
			if(gbd.CrearProducto(nombre,precio,cantidad)==1)
			{
				System.out.println("Producto creado correctamente");
			}
			else {
				System.out.println("El producto no se ha podido crear correctamente");
			}
				
		}

		if(opcion.equals("2"))
		{
		
		productos = gbd.ListarProducto();
		
		for(i=0;i<productos.size();i++) {
			 System.out.println(productos.get(i).getId() + " | " + productos.get(i).getNombre()+ " | " + productos.get(i).getPrecio() + " | " + productos.get(i).getCantidad()); 
			}
		}
		if(opcion.equals("3"))
		{
			
			productos = gbd.ListarProducto();
			
			for(i=0;i<productos.size();i++) {
			System.out.println(productos.get(i).getId() + " | " + productos.get(i).getNombre()+ " | " 
			+ productos.get(i).getPrecio() + " | " + productos.get(i).getCantidad());
			}
		
		    System.out.println(" Introduzca el id del producto ");
			id = sc.nextInt();
			System.out.println(" Introduzca el nombre del producto ");
			nombre = sc.next(); 
			System.out.println(" Introduzca el precio unitario del producto ");
			sc.nextLine();
			precio = sc.nextFloat(); 
			System.out.println(" Introduzca la cantidad del producto ");
			cantidad= sc.nextInt();
			if(gbd.ModificarProducto(id,nombre, precio, cantidad)==1)
			{
				System.out.println("Producto modificado correctamente");
			}else {
				
				System.out.println("El producto no se ha podido modificar");
			}
			
			
			}
			
		if(opcion.equals("4"))
		{	
				
			System.out.println(" Introduzca el identificador del producto a borrar ");
			id = sc.nextInt();
			
			if(gbd.BorrarProducto(id)==1)
					{
				System.out.println("Producto borrado correctamente");
					}
			else {
				
				System.out.println("El producto no pudo ser eliminado");
			}
			
			
			}	
		
} while (!opcion.equals("0"));
System.out.println(" Salió del programa ");

}

}


