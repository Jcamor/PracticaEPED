package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class WordListN {
	/* Atributos de la clase con la estructura adecuada */
	private ListIF<String> wordListN;
	private int size; //tamaño de la palabra
	/* Atributos de la clase con la estructura adecuada */

	public WordListN(int size) {
		
		this.size = size; //inicializamos size con el tamaño de la palabra
		this.wordListN = new List<String>();
				
	}
	
	public void add(String word) {
		
		wordListN.insert((wordListN.size()+1), word);
				
	}
	
	public int getWordSize() {

		return size;
		
	}
	
	public String toString() {
		StringBuilder salida = new StringBuilder();
		int numPalabras = wordListN.size(); /* Longitud de la secuencia de palabras */
		salida.append("Palabras de ");
		salida.append(this.getWordSize());
		salida.append(" letra");
		if ( this.getWordSize() > 1 ) { salida.append('s'); }
		salida.append(": ");
		for (int pos = 1 ; pos <= numPalabras ; pos++) {
			/* Estas líneas dependen de la estructura escogida */
			String word = wordListN.get(pos);/* Obtener la siguiente palabra */
			/* Avanzar a la siguiente sin destruir la estructura */
			//...
			/* Estas líneas dependen de la estructura escogida */
			salida.append(word);
			if ( pos < numPalabras ) {
				salida.append(", ");
			}
		}
		salida.append('\n');
		return salida.toString();
	}
}
