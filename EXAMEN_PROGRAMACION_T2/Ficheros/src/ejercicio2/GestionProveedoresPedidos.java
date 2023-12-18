package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;



public class GestionProveedoresPedidos {
	
	private TreeMap<String, Proveedor> proveedores;
	private TreeMap<String, Producto> productos;
	private String pathFicheroProveedores;
	private String pathFicheroProductos;
	
	public GestionProveedoresPedidos(String pathFicheroProveedores, String pathFicheroProductos) {
		this.pathFicheroProductos = pathFicheroProductos;
		this.pathFicheroProveedores = pathFicheroProveedores; 
		this.proveedores = new TreeMap<>();
		this.setProveedoresFromFichero();
		this.productos = new TreeMap<>();
		this.setProductosFromFichero();
	}
	
	
	public TreeMap<String, Proveedor> getProveedores() {
		return proveedores;
	}
	
	public TreeMap<String, Producto> getProductos() {
		return productos;
	}
	
	public String getPathFicheroProductos() {
		return pathFicheroProductos;
	}
	
	public String getPathFicheroProveedores() {
		return pathFicheroProveedores;
	}
	
	public void setProveedoresFromFichero() {
		File file = new File(this.getPathFicheroProveedores());
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String linea = bufferedReader.readLine();	
			while (linea != null) {
				String[] detallesProveedores = linea.split(":");
				this.getProveedores().put(detallesProveedores[0], new Proveedor(detallesProveedores[0], detallesProveedores[1], detallesProveedores[2]));
				linea = bufferedReader.readLine();	
			}
			bufferedReader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void setProductosFromFichero() {
		File file = new File(this.getPathFicheroProductos());
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String linea = bufferedReader.readLine();	
			while (linea != null) {
				String[] arrayProductos = linea.split(":");
				String[] arrayProveedores = arrayProductos[arrayProductos.length-1].split(",");
				HashSet<Proveedor> proveedoresProductos = new HashSet<>();
				for (String key:arrayProveedores) {
					proveedoresProductos.add(proveedores.get(key));
				}
				Producto producto;
				if (arrayProductos[1].equalsIgnoreCase("i")) {
					producto = new InternacionalProducto(arrayProductos[0], arrayProductos[2], Double.parseDouble(arrayProductos[3]),proveedoresProductos,arrayProductos[4]);
				}
				else {
					producto = new NacionalProducto(arrayProductos[0], arrayProductos[2], Double.parseDouble(arrayProductos[3]),proveedoresProductos);
				}
				this.getProductos().put(producto.getCodProd(), producto);
				linea = bufferedReader.readLine();	
			}
			bufferedReader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	
	public void crearPorducto(String codProd, String tipo, String nombre, double precio, String pais) throws Exception {
		if (this.getProductobyCod(codProd) != null) {
			throw new Exception("ERROR: El producto con código" + codProd + " ya se encuentra registrado en el sistema");
		}
		Producto producto;
		if (tipo.equalsIgnoreCase("i")) {
			producto = new InternacionalProducto(codProd, nombre, precio, pais);
		}
		else {
			producto = new NacionalProducto(codProd, nombre, precio);
		}
		this.getProductos().put(producto.getCodProd(), producto);
	}
	
	public void crearProveedor(String codProv, String nombre, String direccion) throws Exception {
		if (this.getProveedorbyCod(codProv) != null) {
			throw new Exception("ERROR: El provedor con código" + codProv + " ya se encuentra registrado en el sistema!");
		}
		Proveedor proveedor = new Proveedor(codProv, nombre, direccion);
		this.getProveedores().put(proveedor.getCodProv(), proveedor);
	}
	
	public void asignarProveedor(String codProd, String codProv) throws Exception {
		if (this.getProductobyCod(codProd) == null) {
			throw new Exception("ERROR: El producto con código" + codProd + " no se encuentra registrado en el sistema!");
		}
		if (this.getProveedorbyCod(codProv) == null) {
			throw new Exception("ERROR: El provedor con código" + codProv + " no se encuentra registrado en el sistema!");
		}
		// Añadimos proveedor al HashSet<Proveedor> de Productos
		this.getProductos().get(codProd).getProveedores().add(this.getProveedorbyCod(codProv));
		/*
		Proveedor proveedor = this.getProveedorbyCod(codProv);
		this.getProductos().get(codProd).getProveedores().add(proveedor);
		 */
	}
	
	
	public void imprimirProveedoresV2() {
		// Añade al final del fichero lo que queremos escribir
		Set<String> codigosFichero = this.getCodProvFichero();
		Set<String> codigosMemoria = this.getProveedores().keySet();
		codigosMemoria.removeAll(codigosFichero);
		
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.getPathFicheroProveedores(),true))){
			Iterator<String> iterator = codigosMemoria.iterator();
			while (iterator.hasNext()) {
				Proveedor proveedor = this.getProveedores().get(iterator.next());
				bufferedWriter.newLine();
				bufferedWriter.write(proveedor.getCodProv() + ":" + proveedor.getNombre() + ":" + proveedor.getDireccion());
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void imprimirProveedores() {
		File file = new File("FicherosEjercicio2//Proveedores2.txt");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			Iterator<String> iterator = this.getProveedores().keySet().iterator();
			while (iterator.hasNext()) {
				Proveedor proveedor = this.getProveedores().get(iterator.next());
				printWriter.println(proveedor.getCodProv() + ":" + proveedor.getNombre() + ":" + proveedor.getDireccion());
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void imprimirProductos() {
		File file = new File("FicherosEjercicio2//Productos2.txt");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			Iterator<String> iterator = this.getProductos().keySet().iterator();
			while (iterator.hasNext()) {
				Producto producto = this.getProductos().get(iterator.next());
				String linea="";
				if (producto instanceof InternacionalProducto) {
					InternacionalProducto productoInternacional = (InternacionalProducto) producto;
					linea = productoInternacional.getCodProd() + ":i:" + productoInternacional.getNombre() + ":" + productoInternacional.getPrecio() + ":" + productoInternacional.getPais() + ":";
				}
				else {
					linea = producto.getCodProd() + ":n:" + producto.getNombre() + ":" + producto.getPrecio() + ":";
				}
				String codigosProveores = producto.getCodigosProvedoresfromProductos();
				linea = linea.concat(codigosProveores);
				printWriter.println(linea);
			}	
			printWriter.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

	
	public void imprimirProveedoresPantalla() {
		System.out.println("********************** LISTA PROVEEDORES ************************");
		Iterator<String> iterator = this.getProveedores().keySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(this.getProveedores().get(iterator.next()));
		}
		System.out.println("*****************************************************************");
	}
	
	
	public void imprimirProductosPantalla() {
		System.out.println("********************** LISTA PRODUCTOS *************************");
		Iterator<String> iterator = this.getProductos().keySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(this.getProductos().get(iterator.next()));
		}
		System.out.println("*****************************************************************");
	}
	
	
	public Producto getProductobyCod(String codProd) {
		return this.getProductos().get(codProd);
	}
	
	public Proveedor getProveedorbyCod(String codProv) {
		return this.getProveedores().get(codProv);
	}
	
	
	public TreeSet<String> getCodProvFichero(){
		
		TreeSet<String> codigosProvFichero = new TreeSet<>();
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getPathFicheroProveedores()))){
			String linea = bufferedReader.readLine();
			while (linea != null) {
				String codigo = linea.split("^*:")[0];
				codigosProvFichero.add(codigo);
				linea = bufferedReader.readLine();
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return codigosProvFichero;
	}
}
