
public class ProductoEstandar extends Producto   {    //llamado a la clase padre
	
	//atributos de la clase
	public int seccion;
	
	
    //constructor con los atributos de la clase padre
	public ProductoEstandar(String nombre, double precio, int seccion) {
		super(nombre, precio);  //llamado a los atributos de la clase padre
		this.seccion = seccion;
	}
	
	
	//metodos getter and setter
	public int getSeccion() {
		return seccion;
	}
	
	public void setSeccion(int seccion) {
		this.seccion = seccion;
	}
	
	//llamamos al metodo de la clase hija, pero con los cambios especificados 
	@Override
	public double obtenerPrecio(int uni_pedProd) {
		 double precFinal = super.obtenerPrecio(uni_pedProd);
		 if(uni_pedProd >= 5) {
		precFinal *= 0.10;
		 }
		 return precFinal;
		 

	}

}
