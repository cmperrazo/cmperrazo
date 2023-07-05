package INTERFACE14;

public class Circulo implements Figura, Dibujar, Rotar {
	double r;
	
	public Circulo(double r) {
		this.r = r;
	}

	@Override
	public double calcularArea() {
		double pi = 3.1416;
		double resul = pi*r*r;
		return resul;
	}

	@Override
	public void dibujar() {
		System.out.println("Vas a dibujar");
		
	}

	@Override
	public void rotar() {
		System.out.println("Usted va a rodar");
		
	}

}
