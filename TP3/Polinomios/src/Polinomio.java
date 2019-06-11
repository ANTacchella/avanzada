
import java.util.Arrays;

public class Polinomio {
	
	private int grado;
	private double[] coeficientes;

	public Polinomio(int grado, double[] coeficientes) {
		this.grado = grado;
		this.coeficientes = coeficientes;
	}

	public double evaluarMSucesivas(double x) {
		double resultado = 0;
		double potencia;

		for (int i = 0; i < coeficientes.length; i++) {
			potencia = 1;
			for (int j = grado - i; j > 0; j--) {
				potencia *= x;
			}
			resultado += coeficientes[i] * potencia;
		}

		return resultado;
	}//O(n^2)
	
	public double evaluarRecursiva(double x) {
		double resultado = 0;
		for (int i = grado, j = 0; i > 0; i--,j++) {
			resultado += potenciaRecursiva(x,i) * coeficientes[j];
		}
		resultado += coeficientes[coeficientes.length - 1];
		return resultado;
	}//O(n^2)
	
	public double evaluarRecursivaPar(double x) {
        double resultado = 0;
        for (int i = grado, j = 0; i > 0; i--,j++) {
            resultado += potenciaRecursivaPar(x,i) * coeficientes[j];
        }
        resultado += coeficientes[coeficientes.length - 1];
        return resultado;
    }// n * (log(n)/2 + n/2) = n^2 ==> O(n^2)
	
	public double evaluarProgDinamica(double x) {
		double [] potenciasDeX = new double [grado + 1];
		double resultado = 0;
		potenciasDeX[0] = 1; 
		for (int i = 1; i < potenciasDeX.length; i++) {
			potenciasDeX[i] = potenciasDeX[i - 1] * x;
		}
		for (int i = 0,j = grado; i < coeficientes.length; i++, j--) {
			resultado += coeficientes[i] * potenciasDeX[j]; 
		}
		return resultado;
	}//O(n)
	
	public double evaluarMejorada(double x) {
		double [] potenciasDeX = new double [grado + 1];
		double resultado = 0;
		potenciasDeX[0] = 1; 
		resultado += potenciasDeX[0] * coeficientes[grado];
		for (int i = 1, j = grado - 1; i < coeficientes.length; i++, j--) {
			potenciasDeX[i] = potenciasDeX[i - 1] * x;
			resultado += potenciasDeX[i] * coeficientes[j]; 
		}
		return resultado;
	}//O(n)
	
	public double evaluarPow(double x) {
		double [] potenciasDeX = new double [grado + 1];
		double resultado = 0;
		potenciasDeX[0] = 1; 
		resultado += potenciasDeX[0] * coeficientes[grado];
		for (int i = 1, j = grado - 1; i < coeficientes.length; i++, j--) {
			potenciasDeX[i] = Math.pow(x, i); //Math.pow tiene cc de O(1);
			resultado += potenciasDeX[i] * coeficientes[j]; 
		}
		return resultado;
	}//O(n)
	
	private double potenciaRecursiva(double x, int n) {
		if(n - 1 == 0)
			return x;
		return x*potenciaRecursiva(x, n - 1);
	}
	
	private double potenciaRecursivaPar(double x, int n) {
        if(n - 1 == 0)
            return x;
        if(n % 2 == 0)
            return potenciaRecursiva(x * x, n / 2);
        else
            return x*potenciaRecursiva(x, n - 1);
    }
	
	public double evaluarHorner(double x) {
        double resultado = 0, numero_abajo = coeficientes[0];
        for (int i = 1; i < grado; i++) {
            resultado = numero_abajo * x;
            resultado += coeficientes[i];
            numero_abajo = resultado;
        }
        return resultado;
    }//O(n)
	
	@Override
	public String toString() {
		return "Polinomio [grado=" + grado + ", coeficientes=" + Arrays.toString(coeficientes) + "]";
	}
	
	
	
	
}
