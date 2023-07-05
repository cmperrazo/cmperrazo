package INTERFACE14;

public class Triangulo implements Figura, Dibujar, Rotar{
	
	double b;
	double h;
	
	public Triangulo(double b, double h) {
		this.b = b;
		this.h = h;
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcularArea() {
		double result = (b*h)/2;
		return result;
	}

}
