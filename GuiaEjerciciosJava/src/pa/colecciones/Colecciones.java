package pa.colecciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

import pa.pruebaConstructores.*;

public class Colecciones {

	public static void main(String[] args) {
		ArrayList<ClaseA> arrayList= new ArrayList<ClaseA>();
		LinkedList<ClaseA> linkedList = new LinkedList<ClaseA>();
		TreeSet<ClaseA> treeSet= new TreeSet<ClaseA>();
		ClaseA o = new ClaseA(); 
		arrayList.add(o);
		arrayList.add(o);
		
		treeSet.add(o);
		
		for(ClaseA o1: arrayList) {
			System.out.println(o1);
		}
	}

}
