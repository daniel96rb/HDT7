import java.util.ArrayList;
import java.util.List;

/**
* Clase: Main.java
* @author Daniel Rodriguez, Ana lucia Leppe
*/

public class Main {

	private Node nodo1;
	private Node nodo2;

	public static void main(String[] args){

		//Se crea el arbol y arrays de la clase Association
		BinaryTree arbol = new BinaryTree();
		Association<String,String> [] miLista = new Association[36];
      Association temp = new Association();
     	int count=0;

     	//Se lee el diccionario y se ingresa al arbol
	    String diccionario = temp.leerArchivo("diccionario.txt");
	    for (String sp : diccionario.split("-")) {
		String st[] = sp.split(",");
		miLista[count] = new Association<String, String>(st[0].substring(1), st[1].substring(1, st[1].length()-1));
		arbol.insertNode(miLista[count]);
		count ++;
        }

	   if(miLista[0].compareTo(miLista[1])>1){
			 nodo2.setValue(miLista[1]);
			 nodo1.setRight(nodo2);
		 }else{
			 nodo2.setValue(miLista[1]);
			 nodo1.setLeft(nodo2);
		 }


	}
}
