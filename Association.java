/**
* Clase: Association.java
* Clase que permite las asociaciones de las palabras (ingles, espaniol) del diccionario
* @author Daniel Rodriguez, Ana Lucia Leppe
*/

import java.io.*;


public class Association<K,V> {
	protected K ingles;
	protected V espaniol;
	//Metodos
	public Association()
	// post: constructor that generates an empty node
	{
		ingles = null;
		espaniol = null;
	}
	public Association(K ingles,  V espaniol){
		this.ingles= ingles;
		this.espaniol = espaniol;

		}
	//Metodos Sets
	public void setEnglish(K palabra){
		ingles = palabra;
	}
	public void setSpanish(V palabra){
		espaniol = palabra;
	}
	public K getKey(){
		return ingles;
	}
	public V getValue(){
		return espaniol;
	}

	//Metodo que realiza la lectura del archivo y realiza las particiones en las palabras que luego seran traducidas.
    public String lectura(String direccion) {
		String res = "";
		String temp = "";
		try {
			FileReader f = new FileReader(direccion);
			BufferedReader b = new BufferedReader(f);
			try {
				while ((temp = b.readLine()) != null) {
					res += temp + "-";
				}
				b.close();
			} catch (IOException e) {
				return "";
			}
		} catch (FileNotFoundException e) {
			return "";
		}
		return res;
	}


}
