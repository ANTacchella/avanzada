package pa.excepciones;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Excepcion {

	public static void main(String[] args) {
		int numero1;
		int numero2;
		String path;
		try {
			numero1 = 5;
			numero2 = 0;
			PruebaAritmethicException test = new PruebaAritmethicException(numero1, numero2);
			test.division();
		}
		catch (ArithmeticException excepcionAritmetica){
			System.out.println(excepcionAritmetica.toString());			
		}
		
		try {
			path = "src/archivo.in";
			PruebaIOException test = new PruebaIOException(path);
			test.open();
		}
		catch (IOException excepcionIO){
			System.out.println(excepcionIO.toString());			
		}

	}

}

class PruebaAritmethicException {
	private int numerador;
	private int denominador;
	
	public PruebaAritmethicException(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	public int division() throws ArithmeticException{
		return numerador/denominador;
	}
}

class PruebaIOException{
	private String path;
	
	public PruebaIOException(String path) {
		this.path = path;
	}
	
	public void open() throws IOException{
		Scanner sc = new Scanner(new File(path));
	}
}