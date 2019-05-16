package pa.monticulo;

import javax.management.RuntimeErrorException;

public class Monticulo {
	private int[] monticulo;
	private int cantElem;
	
	public Monticulo() {
		monticulo = new int[2];
		cantElem = 0;
	}
	
	public void insertar(int dato) {
		if(cantElem == monticulo.length - 1)
			monticulo = java.util.Arrays.copyOf(monticulo, monticulo.length * 2);
		
		monticulo[++cantElem] = dato;
		if(cantElem > 1)
			conservarMonticuloInsertar(cantElem, cantElem/2);
	}
	
	public void conservarMonticuloInsertar(int posHijo, int posPadre) {
		if(posPadre != 0) {
			if(consulta(monticulo[posHijo], monticulo[posPadre])) {
				intercambio(posHijo, posPadre);
				conservarMonticuloInsertar(posPadre, posPadre/2);
			}
		}
	}
	
	public int quitar() {
		if(isEmpty())
			throw new RuntimeErrorException(null, "No hay elementos.");
		int aux = monticulo[1];
		monticulo[1] = monticulo[cantElem];
		conservarMonticuloQuitar(1*2, 1*2 + 1);
		cantElem--;
		return aux;
	}
	
	public void conservarMonticuloQuitar(int posHijoIzq, int posHijoDer) {
		if(cantElem >= posHijoDer) {
			if(consulta(monticulo[posHijoIzq], monticulo[posHijoDer])) {
				if(consulta(monticulo[posHijoIzq], monticulo[posHijoIzq/2])) {
					int posPadre = posHijoIzq/2;
					intercambio(posHijoIzq, posPadre);
					conservarMonticuloQuitar(posHijoIzq*2, posHijoIzq*2 + 1);
				}
			}
			else {
				if(consulta(monticulo[posHijoDer], monticulo[posHijoDer/2])) {
					int posPadre = posHijoDer/2;
					intercambio(posHijoDer, posPadre);				
					conservarMonticuloQuitar(posHijoDer*2, posHijoDer*2 + 1);
				}
			}
		}
		else if(cantElem >= posHijoIzq) {
			if(consulta(monticulo[posHijoIzq], monticulo[posHijoIzq/2])) {
				int posPadre = posHijoIzq/2;
				intercambio(posHijoIzq, posPadre);				
			}
		}
	}
	
	public void intercambio(int posHijo, int posPadre) {
		int auxPadre = monticulo[posPadre];
		monticulo[posPadre] = monticulo[posHijo];
		monticulo[posHijo] = auxPadre;	
	}
	
	public int getMasPrioritario() {
		if(isEmpty())
			throw new RuntimeErrorException(null, "No hay elementos.");
		return monticulo[1];
	}
	
	public void empty() {
		cantElem = 0;
	}
	
	public boolean isEmpty() {
		return cantElem == 0;
	}
	
	public boolean consulta(int nodo1, int nodo2) {
		return nodo1 < nodo2;
	}
	
	public void imprimir() {
		for(int i = 0; i < monticulo.length; i++)
			System.out.println(monticulo[i]);
	}
}
