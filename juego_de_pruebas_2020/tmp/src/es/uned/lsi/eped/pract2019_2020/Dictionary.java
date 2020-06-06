package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.*;

public class Dictionary {

	protected GTree<Node> dict; /* El diccionario es un árbol general de nodos */
	int contador = 0;

	/* Constructor de la clase */
	public Dictionary() {
		this.dict = new GTree<Node>();
		this.dict.setRoot(new RootNode());
	}

	/* Método de inserción de una nueva palabra en el diccionario */
	public void insert(String word) {
		/* Insertamos la palabra a partir del nodo raíz del árbol */
		word = word.trim(); // Quito los espacios si los hubiera

		if (word.length() != 0) { // no de que entren palabras de 0 letras
			insertInTree(word, this.dict);
		}
	}

	/* Método privado llamado por el anterior */
	private void insertInTree(String word, GTreeIF<Node> node) {

		GTreeIF<Node> nuevo = new GTree<Node>();
		boolean noEncontrado = true; // boleano para saber si hemos encontrado dos iguales
		int posicion = 1;
		String letraHijo; // letra del nodo

		if (word.length() == 0) { // si palabra llega a 0 metemos un "WN" de fin de palabra
			if (node.getNumChildren() > 0) {
				if (node.getChild(1).getRoot().getNodo() != "WN") { // comprobamos que no esté ya el WN por que sería
																	// palabra repetida
					nuevo.setRoot(new WordNode());
					node.addChild(1, nuevo);
				}
			} else {
				nuevo.setRoot(new WordNode());
				node.addChild(1, nuevo);
			}
		} else {
			String letra = String.valueOf(word.charAt(0)); // variable letra con la letra primera de la palabra
			if (node.getNumChildren() > 0) { // preguntamos si ya hay algún hijo
				for (int i = 1; i <= node.getNumChildren(); i++) {
					letraHijo = node.getChild(i).getRoot().getNodo(); // variable con la letra del nodo
					if (letraHijo.equals(letra)) { // preguntamos si son las mismas letras para bajar por el nodo
						nuevo = node.getChild(i);
						noEncontrado = false; // como esta la letra ponemos el booleano a false
						break; // rompemos el for ya que hemos encontrado la misma letra
					} else {
						if (letraHijo.compareTo(letra) > 0) { // si la letra del nodo es mayor que la letra del word
							posicion = i; // usamos es posición ya que la letra del nodo es mayor
							noEncontrado = true; // como no está repetida ponemos el booleano a true
							break;
						}
						if (i == node.getNumChildren()) { // si llegamos al final y ningún nodo hijo es mayor que la
															// letra
							posicion = i + 1; // posicion es la última de la lista
							noEncontrado = true; // como no está repetida ponemos el booleano a true
						}
					}
				}
				if (noEncontrado) { // si no está repetido lo guardamos en ese nodo
					nuevo.setRoot(new LetterNode(letra));
					node.addChild(posicion, nuevo);
				}
			} else { // si no tiene hijos la lista, lo ponemos como primero
				nuevo.setRoot(new LetterNode(letra));
				node.addChild(1, nuevo);
			}
			insertInTree(word.substring(1), nuevo); // hacemos la llamada recursiva
		}
	}

	/* Método público de búsqueda de todas las palabras a partir de una secuencia */
	public WordList search(String sequence) {
		WordList salida = new WordList(); /* Variable donde construiremos la salida */
		searchInTree(sequence, "", this.dict, salida); /* Construimos la salida recursivamente */
		return salida;
	}

	/* Método privado llamado por el anterior */
	private void searchInTree(String sequence, String word, GTreeIF<Node> node, WordList salida) {
		String letraHijo; // letra que hay en el nodo
		String wordAux; // palabra auxiliar para llamada recursiva
		String sequenceAux; // sequencia auxiliar para llamada recursiva
		GTreeIF<Node> nodeAux; // nodo auxiliar para la llamada recursiva

		for (int i = 1; i <= node.getNumChildren(); i++) { // recorremos la lista de hijos
			letraHijo = node.getChild(i).getRoot().getNodo(); // asignamos la letra del nodo en la variable
			if (sequence.contains(letraHijo)) { // si encontramos la letra del nodo en la sequencia
				wordAux = word.concat(letraHijo); // metemos esa letra en la palabra que estamos formando
				sequenceAux = sequence.replaceFirst(letraHijo, ""); // borramos la letra encontrada de la sequencia
				nodeAux = node.getChild(i); // pasamos el nodo para la llamada recursiva
				searchInTree(sequenceAux, wordAux, nodeAux, salida);
			} else if (letraHijo == "WN") { // si hemos encontrado un WN de fin de palabra
				salida.add(word); // añadimos la palabra al wordList
			}

		}
	}

	/*
	 * Método público de búsqueda de todas las palabras de tamaño size a partir de
	 * una secuencia
	 */
	public WordListN search(String sequence, int size) {
		WordListN salida = new WordListN(size); /* Variable donde construiremos la salida */
		searchInTreeN(sequence, "", this.dict, salida, size); /* Construimos la salida recursivamente */
		return salida;
	}

	/* Método privado llamado por el anterior */
	private void searchInTreeN(String sequence, String word, GTreeIF<Node> node, WordListN salida, int size) {
		// los mismo que el método searchInTree pero comprobamos el tamaño de palabra
		// que nos pide
		String letraHijo;
		String wordAux;
		String sequenceAux;
		GTreeIF<Node> nodeAux;

		for (int i = 1; i <= node.getNumChildren(); i++) {
			letraHijo = node.getChild(i).getRoot().getNodo();
			if (sequence.contains(letraHijo)) {
				wordAux = word.concat(letraHijo);
				sequenceAux = sequence.replaceFirst(letraHijo, "");
				nodeAux = node.getChild(i);
				searchInTreeN(sequenceAux, wordAux, nodeAux, salida, size);
			} else if (letraHijo == "WN") {
				if (word.length() == size) { // solo la pasamos si el tamaño es el que nos ha pedido
					salida.add(word);
				}
			}

		}
	}

}