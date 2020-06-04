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

	public static void main(String[] args) {

		Dictionary dict = new Dictionary();

		dict.insert("casa");
		dict.insert("caso");
		dict.insert("casco");
		dict.insert("caos");
		dict.insert("saco");
		dict.insert("casos");
		dict.insert("cosa");
		dict.insert("ocas");
		dict.insert("asco");
		dict.insert("soca");
		dict.insert("ocaso");

		WordList wordListSalida = dict.search("cascao");
		WordListN wordNSalida = dict.search("cascao", 4);
	

		System.out.println("Salida desde el main: ");
		System.out.println(wordListSalida.toString());
		System.out.println("Salida desde el main: con WordListN ");
		System.out.println(wordNSalida.toString());

	}

	/* Método de inserción de una nueva palabra en el diccionario */
	public void insert(String word) {
		/* Insertamos la palabra a partir del nodo raíz del árbol */
		word = word.trim();

		if (word.length() != 0) {
			insertInTree(word, this.dict);
		}
	}

	/* Método privado llamado por el anterior */
	private void insertInTree(String word, GTreeIF<Node> node) {

		GTreeIF<Node> nuevo = new GTree<Node>();
		boolean noEncontrado = true;
		int posicion = 1;
		String letraHijo;

		if (word.length() == 0) {
			if (node.getNumChildren() > 0) {
				if (node.getChild(1).getRoot().getNodo() != "WN") { // comprobamos q no haya palabras repetidas
					nuevo.setRoot(new WordNode());
					node.addChild(1, nuevo);
				}
			} else {
				nuevo.setRoot(new WordNode());
				node.addChild(1, nuevo);
			}
		} else {
			String letra = String.valueOf(word.charAt(0));
			if (node.getNumChildren() > 0) {
				for (int i = 1; i <= node.getNumChildren(); i++) { // Recorremos los hijos
					letraHijo = node.getChild(i).getRoot().getNodo(); // Sacamos letra del nodo
					if (letraHijo.equals(letra)) {
						nuevo = node.getChild(i);
						noEncontrado = false; // si lo encuentra ponemos a false el booleano
						break;
					}
					if (letraHijo.compareToIgnoreCase(letra) > 0) { // para ordenarlo si la letra que entra es menor que
																	// la del hijo
						if (node.getChild(i).isLeaf()) { // Comprobamos que si hay un WN ya se vaya por la derecha
							posicion = i + 1;
						} else {
							posicion = i;
						}
						noEncontrado = true; // si no lo encuentra ponemos a true el booleano
						break;
					} else {
						posicion = node.getNumChildren() + 1; // si la letra q entra es mayor que la del hijo
					}
				}
				if (noEncontrado) { // comprobamos q no lo hay encontrado para añadirlo
					nuevo.setRoot(new LetterNode(letra));
					node.addChild(posicion, nuevo);
				}
			} else { // al no tener hijo lo metemos en la primera posición
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
				searchInTree(sequenceAux, wordAux, nodeAux, salida);
			} else if (letraHijo == "WN") {
				salida.add(word);
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
				if (word.length() == size) {
					salida.add(word);
				}
			}

		}
	}

}