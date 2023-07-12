
public class ProductoOfertado extends Producto {
	
	//atributos de la clase
	public int dias;
	
	//constructor con los atributos de la clase padre
	public ProductoOfertado(String nombre, double precio, int dias) {
		super(nombre, precio); //llamado a los atributos de la clase padre
		this.dias = dias;
	}
	
	//metodos getter and setter
	public int getDias() {
		return dias;
	}
	
	public void setDias(int dias) {
		this.dias = dias;
	}
	
	//llamado al metodo de la clase padre
	
	@Override
	public double obtenerPrecio(int uni_pedProd) {
		 double precFinal = super.obtenerPrecio(uni_pedProd);
		 if(dias ==1) {
			 precFinal *= 0.20;
		 }else if(dias ==2||dias ==3) {
			 precFinal *= 0.15;	 
		 }else if(dias >3 ) {
			 precFinal *= 0.10;
		 }
		 return precFinal;
			 
		
	}

	

}
