import java.util.ArrayList;
import java.util.List;

/**
* Clase: Main.java
* @author Daniel Rodriguez, Ana lucia Leppe
* Clase Main donde se utilizan el bosque binario para realizar una busqueda de palabras traducidas del ingles para
* realizar una traduccion de un archivo teniendo un documento de dicccionario de asociaciones.
*/

public class Main {

	private Node nodo1;
	private Node nodo2;

	public static void main(String[] args){

		//Se realizan las instancias del arbol y el arreglo de la Association
		BinaryTree arbol = new BinaryTree();
		Association<String,String> [] miLista = new Association[39];
    Association assoc = new Association();
    int conteo = 0;

     	//Se realiza la lectura del diccionario y se ingresa al arbol
	    String diccionario = assoc.lectura("diccionario.txt");
	    for (String sp : diccionario.split("-")) {
		String st[] = sp.split(",");
		miLista[conteo] = new Association<String, String>(st[0].substring(1), st[1].substring(1, st[1].length()-1));
		arbol.insertNode(miLista[conteo]);
		conteo ++;
        }

	  //Atraviesa el arbol
	  arbol.busquedaInOrder();

	  String archivo = assoc.lectura("archivo.txt");
	  String textoATraducir = archivo.substring(0, archivo.length()-1);
	  System.out.println("La conversacion en ingles es: \n"+textoATraducir+"\n");


		//Realiza el recorrimiento del texto A Traducir
		int inicio = 0;
		int num=0;
		List<String> Text = new ArrayList<>();
		for(int i = 0; i <textoATraducir.length(); i++){
			if(Character.toString(textoATraducir.charAt(i)).equals(" ") | Character.toString(textoATraducir.charAt(i)).equals(".")){
				Text.add(textoATraducir.substring(inicio, i));
				inicio = i;
				num++;
			}
		}

    //Con los metodos del BinaryTree de busqueda se realizan las traducciones.
    String resultado = "";
    for(int n = 0; n<num; n++){
    		String palabra = arbol.Busqueda(Text.get(n).replace(" ",""));
        String palabraSegunda = Text.get(n).replace(" ","");

      	if(palabra.equals(palabraSegunda)){
      			resultado = resultado+" "+Text.get(n).replace(" ","")+" ";

        }
        else{
					resultado=resultado+arbol.Busqueda(Text.get(n).replace(" ","")+"")+" ";
				}
   }

  //Imprime la Traduccion
  System.out.println("La conversacion en espaniol es: \n"+resultado+"\n");
	}
}
