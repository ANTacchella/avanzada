
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PolinomioTest {

	@Test
	public void quePruebaPolinomiosValuadosConPositivosSucesiva(){
		double[] vectorCoeficientes = {5,3,2,3,2};
		Polinomio polinomio = new Polinomio(4, vectorCoeficientes);
		assertEquals(120,polinomio.evaluarMSucesivas(2),0.000001);
	}
	
	@Test
	public void quePruebaPolinomiosValuadosConNegativosSucesiva(){
		double[] vectorCoeficientes = {5,3,2,3,2};
		Polinomio polinomio = new Polinomio(4, vectorCoeficientes);
		assertEquals(60,polinomio.evaluarMSucesivas(-2),0.000001);
	}
	
	@Test
	public void quePruebaPolinomiosConCoeficientesNegativosValuadosConPositivosSucesiva(){
		double[] vectorCoeficientes = {-5,-3,2,-3,2};
		Polinomio polinomio = new Polinomio(4, vectorCoeficientes);
		assertEquals(-100,polinomio.evaluarMSucesivas(2),0.000001);
	}
	
	@Test
	public void quePruebaPolinomiosConCoeficientesNegativosValuadosConNegativosSucesiva(){
		double[] vectorCoeficientes = {-5,-3,2,-3,2};
		Polinomio polinomio = new Polinomio(4, vectorCoeficientes);
		assertEquals(-40,polinomio.evaluarMSucesivas(-2),0.000001);
	}
	
	@Test
	public void quePruebaPolinomiosValuadosConPositivosRecursiva(){
		double[] vectorCoeficientes = {5,3,2,3,2};
		Polinomio polinomio = new Polinomio(4, vectorCoeficientes);
		assertEquals(120,polinomio.evaluarRecursiva(2),0.000001);
	}
	
	@Test
	public void quePruebaPolinomiosValuadosConPositivosRecursivaPar(){
		double[] vectorCoeficientes = {5,3,2,3,2};
		Polinomio polinomio = new Polinomio(4, vectorCoeficientes);
		assertEquals(120,polinomio.evaluarRecursivaPar(2),0.000001);
	}
	
	@Test
	public void quePruebaEvaluarHorner() {
		double[] coeficientes = {4,7,3,6,2};
		Polinomio polinomio = new Polinomio(5, coeficientes);
		assertEquals(20210, polinomio.evaluarHorner(8),0.0000001);
	}
	
	@Test
	public void quePruebaPrimerPuntoBinomio(){
		BinomioDeNewton binomio = new BinomioDeNewton(2, 3, 2);
		assertEquals(4, binomio.obtenerCoeficienteK(2),0.00001);
	}
	
	@Test
	public void quePruebaSegundoPuntoBinomio(){
		BinomioDeNewton binomio = new BinomioDeNewton(2, 3, 3);
		assertEquals(343, binomio.obtenerCoeficientesYEvaluar(2),0.00001);
	}
	
}
