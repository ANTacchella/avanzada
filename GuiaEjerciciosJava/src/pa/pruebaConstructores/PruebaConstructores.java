package pa.pruebaConstructores;

public class PruebaConstructores {
	
		public static void main(String [ ] args) {
			System.out.println("Pruebas 2");
			ClaseC o = new ClaseC(1);
			ClaseB o2 = new ClaseC(1);
			ClaseB o3 = new ClaseC(1);
			ClaseA o4 = new ClaseA();
			//int numeroPrivate = o4.numeroPrivate;//prueba de que el atributo numeroPrivate no es visible  
									//por fuera de la clase, en el mismo paquete
			//int numeroPackage = o4.numeroPackage;//prueba de que el atributo numeroPackage es visible  
												//por fuera de la clase, en el mismo paquete
			//int numeroProtected = o4.numeroProtected;//prueba de que el atributo numeroProtected es visible  
												//por fuera de la clase, en el mismo paquete
			//int numeroPublic = o4.numeroPublic;//prueba de que el atributo numeroPublic es visible  
													//por fuera de la clase, en el mismo paquete
		}
	}

class ClaseB extends ClaseA {
	public ClaseB() { System.out.print (20); }
	
//	public int pruebaVisibilidadPrivate() {
//		return this.numeroPrivate;//prueba de que el atributo numeroPrivate no es visible 
								//por fuera de la clase padre
//	}
	
//	public int pruebaVisibilidadPackage() {
//		return this.numeroPackage;//prueba de que el atributo numeroPackage es visible 
//								//por fuera de la clase padre
//	}
	
//	public int pruebaVisibilidadProtected() {
//		return this.numeroProtected;//prueba de que el atributo numeroProtected es visible 
//								//por fuera de la clase padre
//	}
	
//	public int pruebaVisibilidadPublic() {
//		return this.numeroPublic;//prueba de que el atributo numeroPublic es visible 
//									//por fuera de la clase padre
//	}
	
}

class ClaseC extends ClaseB {
	public ClaseC(int A) { System.out.print (30); } 
}
