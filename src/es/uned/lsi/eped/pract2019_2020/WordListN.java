package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class WordListN {
	/* Atributos de la clase con la estructura adecuada */
	private ListIF<String> wordListN;
	private int size; // tamaño de la palabra
	/* Atributos de la clase con la estructura adecuada */

	public WordListN(int size) {

		this.size = size; // inicializamos size con el tamaño de la palabra
		this.wordListN = new List<String>();

	}

	public void add(String word) {  // añadimos la palabra con su tamaño
		this.wordListN.insert(wordListN.size() + 1, word);

	}

	public int getWordSize() { // nos da el tamaño de la palabra

		return this.size;

	}

	public String toString() {
		StringBuilder salida = new StringBuilder();
		int numPalabras = wordListN.size();/* Longitud de la secuencia de palabras */
		salida.append("-Palabras de ");
		salida.append(this.getWordSize());
		salida.append(" letra");
		if (this.getWordSize() > 1) {
			salida.append('s');
		}
		salida.append(": ");
		for (int pos = 1; pos <= numPalabras; pos++) {
			String word = wordListN.get(pos);/* Obtener la siguiente palabra */

			salida.append(word);
			if (pos < numPalabras) {
				salida.append(", ");
			}
		}
		salida.append('\n');
		return salida.toString();
	}
}
