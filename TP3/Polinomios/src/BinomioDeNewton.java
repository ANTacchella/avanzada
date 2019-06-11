
public class BinomioDeNewton {
	
	private double a;
	private double b;
	private int n;
	private Polinomio polinomio;
	
	public BinomioDeNewton(double a, double b, int n) {
		this.a = a;
		this.b = b;
		this.n = n;
	}
	
	public double obtenerCoeficienteK(int k){
		double coeficienteBinomial = factorial(n) / (factorial(k) * factorial(n - k));
		double numerador = Math.pow(a, k) * Math.pow(b, n - k);
		return coeficienteBinomial * numerador;
	}//O(n)
	
	public double obtenerCoeficientesYEvaluar(double x){
		double[] coeficientes = new double[n + 1];
		for (int i = 0, j = n; i <= n; i++, j--) {
			coeficientes[i] = obtenerCoeficienteK(j);
		}
		polinomio = new Polinomio(n + 1, coeficientes);
		return polinomio.evaluarHorner(x);
	}//O(n^2)
	
	private double factorial(double x) {
		double factorial = 1;
		for (double i = x; i > 0; i--) {
			factorial *= i;
		}
		return factorial;
	}
}
