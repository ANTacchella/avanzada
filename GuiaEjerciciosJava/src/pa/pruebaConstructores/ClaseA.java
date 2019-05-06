package pa.pruebaConstructores;

import pa.excepciones.ClaseAException;

public class ClaseA {
	private int numeroPrivate;
	int numeroPackage;
	protected int numeroProtected;
	public int numeroPublic;
	
	public ClaseA(int numeroPrivate) throws ClaseAException{ 
		System.out.print(10); 
		this.setNumeroPrivate(numeroPrivate);
	}
	
	public int getNumeroPrivate() {
		return numeroPrivate;//prueba de que el atributo numeroPrivate es accesible en la misma clase
	}
	
	//Manejo de excepciones de ClaseA
	public void setNumeroPrivate(int numeroPrivate) throws ClaseAException{
		if(numeroPrivate < 0)
            throw new ClaseAException("El numero debe ser mayor o igual a cero.");
		
		this.numeroPrivate = numeroPrivate;
	}

	public int getNumeroPackage() {
		return numeroPackage;//prueba de que el atributo numeroPackage es accesible en la misma clase
	}

	public int getNumeroProtected() {
		return numeroProtected;//prueba de que el atributo numeroProtected es accesible en la misma clase
	}
	
	public int getNumeroPublic() {
		return numeroPublic;//prueba de que el atributo numeroPublic es accesible en la misma clase
	}

	@Override
	public String toString() {
		return "ClaseA [numeroPrivate=" + numeroPrivate + ", numeroPackage=" + numeroPackage + ", numeroProtected="
				+ numeroProtected + ", numeroPublic=" + numeroPublic + "]";
	}
}
