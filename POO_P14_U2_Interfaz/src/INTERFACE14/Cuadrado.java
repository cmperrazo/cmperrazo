package INTERFACE14;

public class Cuadrado implements Figura, Dibujar {
	
	double lado;
	
	public Cuadrado(double lado) {
		this.lado = lado;
	}

	@Override
	public double calcularArea() {
		double result = lado * lado;
		return result;
	}

	@Override
	public void dibujar() {
		System.out.println("Vas a dibujae");
		
	}

}
