package coloreo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static Coloreo leerArchivo(String path) throws FileNotFoundException {
		Scanner lector = new Scanner(new File(path));
		int V = lector.nextInt();
		int A = lector.nextInt();
		Coloreo c = new Coloreo(V, A);
		for (int i = 0; i < A; i++) {
			c.agregarArista(lector.nextInt(), lector.nextInt());
		}
		lector.close();
		return c;
	}

	public static void escribirArchivo(String path, Coloreo c) throws FileNotFoundException {
		PrintWriter escritor = new PrintWriter(new File(path));
		escritor.println(c.cantColores);
		for (int i = 0; i < c.cantVertices; i++) {
			escritor.println(i + " " + c.nodosPintados.get(i));
		}
		escritor.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
/**		CASO EASY 1
 * 		
 
		int secuencia[] = { 3, 0, 1, 2, 4 }; 
		Coloreo c = new Coloreo( secuencia.length, 5, secuencia);
		
		c.agregarArista(0, 1);
		c.agregarArista(0, 2);
		c.agregarArista(1, 3);
		c.agregarArista(2, 3);
		c.agregarArista(3, 4);
		
		c.resolver();
		System.out.println( c.cantColores );
*/
		
/**		CASO EASY 2
			
		 
		int secuencia[] = { 0, 2, 3, 1, 5, 4 }; 
		Coloreo c = new Coloreo( secuencia.length, 7, secuencia);
				
		c.agregarArista(0, 1);
		c.agregarArista(1, 2);
		c.agregarArista(0, 3);
		c.agregarArista(0, 5);
		c.agregarArista(2, 3);
		c.agregarArista(2, 4);
		c.agregarArista(3, 5);
				
		c.resolver();
		System.out.println( c.cantColores );
		
*/
/**		CASO MODERADO
*/		
		 
		// { 2, 3, 7, 1, 4, 5, 6, 10, 0, 8, 11, 12, 9 }; 
//		Coloreo c = new Coloreo( 14, 24 );
//		
//		c.agregarArista(0, 1);
//		c.agregarArista(0, 3);
//		c.agregarArista(1, 2);
//		c.agregarArista(1, 3);
//		c.agregarArista(2, 3);
//		c.agregarArista(2, 4);
//		c.agregarArista(2, 7);
//		c.agregarArista(3, 8);
//		c.agregarArista(4, 5);
//		c.agregarArista(4, 6);
//		c.agregarArista(5, 6);
//		c.agregarArista(5, 12);
//		c.agregarArista(6, 10);
//		c.agregarArista(7, 8);
//		c.agregarArista(7, 9);
//		c.agregarArista(7, 10);
//		c.agregarArista(10, 11);
//		c.agregarArista(11, 12);
//
//		c.agregarArista(3, 9);
//		c.agregarArista(0, 8);
//		c.agregarArista(6, 7);
//		c.agregarArista(2, 13);
//		c.agregarArista(4, 13);
//		c.agregarArista(5, 13);		
		
		Coloreo c = leerArchivo("grafoTorneo.in");
		
		int secuencia[] = c.calcularSecuencia( 1 ); // 1 para Wp, 2 para M
		c.resolver( secuencia );
		
		Integer[] array = new Integer[c.cantVertices];
		for(int i = 0; i < c.cantVertices; i++) {
			array[i] = i;
		}
 
        List<Integer> l = Arrays.asList(array);
        
    	System.out.println( c.cantColores );
        Random rnd = new Random();        
        while(c.cantColores > 94) {
        	c.nodosPintados = new HashMap<Integer, Integer>();
        	c.cantColores = 0;
        	int[] sec = new int[c.cantVertices];
        	// Shuffle the elements in the array	
        	Collections.shuffle(l, new Random(rnd.nextLong()));
        	for(int i = 0; i < c.cantVertices; i++) {
        		sec[i] = l.get(i);
        	}
        	c.resolver( sec );
        	System.out.println( c.cantColores );
        }
        
		ProgramaProbador pp = new ProgramaProbador(c.cantVertices, c.cantAristas, c.secuencia, c.grafo, c.cantColores, c.nodosPintados);
		
		System.out.println( pp.resolver() );
		
		escribirArchivo("grafoTorneo.out", c);
	}

}
