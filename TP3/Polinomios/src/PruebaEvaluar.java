
import org.junit.Test;

public class PruebaEvaluar {
	
	@Test
	public void evaluarPolinomiosMSucesivas(){
		double[] vectorCoeficientes = new double[10000];
		for(int i = 1; i <= 10000; i++) {
			vectorCoeficientes[i - 1] = i; 
		}
		Polinomio polinomio = new Polinomio(9999, vectorCoeficientes);
		polinomio.evaluarMSucesivas(2);
	}
	
	@Test
	public void evaluarPolinomiosRecursiva(){
		double[] vectorCoeficientes = new double[10000];
		for(int i = 1; i <= 10000; i++) {
			vectorCoeficientes[i - 1] = i; 
		}
		Polinomio polinomio = new Polinomio(9999, vectorCoeficientes);
		polinomio.evaluarRecursiva(2);
	}
	
	@Test
	public void evaluarPolinomiosRecursivaPar(){
		double[] vectorCoeficientes = new double[10000];
		for(int i = 1; i <= 10000; i++) {
			vectorCoeficientes[i - 1] = i; 
		}
		Polinomio polinomio = new Polinomio(9999, vectorCoeficientes);
		polinomio.evaluarRecursivaPar(2);
	}
	
	@Test
	public void evaluarPolinomiosProgDinamica(){
		double[] vectorCoeficientes = new double[10000];
		for(int i = 1; i <= 10000; i++) {
			vectorCoeficientes[i - 1] = i; 
		}
		Polinomio polinomio = new Polinomio(9999, vectorCoeficientes);
		polinomio.evaluarProgDinamica(2);
	}
	
	@Test
	public void evaluarPolinomiosMejorada(){
		double[] vectorCoeficientes = new double[10000];
		for(int i = 1; i <= 10000; i++) {
			vectorCoeficientes[i - 1] = i; 
		}
		Polinomio polinomio = new Polinomio(9999, vectorCoeficientes);
		polinomio.evaluarMejorada(2);
	}
	
	@Test
	public void evaluarPolinomiosPow(){
		double[] vectorCoeficientes = new double[10000];
		for(int i = 1; i <= 10000; i++) {
			vectorCoeficientes[i - 1] = i; 
		}
		Polinomio polinomio = new Polinomio(9999, vectorCoeficientes);
		polinomio.evaluarPow(2);
	}
	
	@Test
	public void evaluarPolinomiosHorner(){
		double[] vectorCoeficientes = new double[10000];
		for(int i = 1; i <= 10000; i++) {
			vectorCoeficientes[i - 1] = i; 
		}
		Polinomio polinomio = new Polinomio(9999, vectorCoeficientes);
		polinomio.evaluarHorner(2);
	}
	
	@Test
	public void polinomiosBinomioNewtonCoefK(){
		BinomioDeNewton binomio = new BinomioDeNewton(2, 3, 10000);
		binomio.obtenerCoeficienteK(9998);
	}
	
	@Test
	public void evaluarPolinomiosBinomioNewtonCoef(){
		BinomioDeNewton binomio = new BinomioDeNewton(2, 3, 10000);
		binomio.obtenerCoeficientesYEvaluar(2);
	}
}
