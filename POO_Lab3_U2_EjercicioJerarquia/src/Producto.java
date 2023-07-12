
public class Producto {
	//atributos de la clase
	public String nombre;
	public double precio;
	
	//constructor
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	
	//metodos getter and setter
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	//metodo para la obtencion del precio del producto
	public double obtenerPrecio(int uni_pedProd) {
		return uni_pedProd * precio; //retorna el precio
	}

}
