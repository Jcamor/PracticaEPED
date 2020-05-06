package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;

public class Dictionary {

	protected GTree<Node> dict; /* El diccionario es un árbol general de nodos */
	int contador = 0;

	/* Constructor de la clase */
	public Dictionary() {
		this.dict = new GTree<Node>();
		this.dict.setRoot(new RootNode());
	}

	public static void main(String[] args) {
		Dictionary diccionario = new Dictionary();
		/*
		 * diccionario.insert("anfibio"); diccionario.insert("alcantarilla");
		 * diccionario.insert("alcantarillado"); diccionario.insert("bicicleta");
		 * diccionario.insert("alicates"); diccionario.insert("alcazar");
		 * diccionario.insert("alicatado"); diccionario.insert("alfeizar");
		 * diccionario.insert("binario"); diccionario.insert("bisiesto");
		 * diccionario.insert("alfombra"); diccionario.insert("bisectriz");
		 */
		// diccionario.insert("");
		diccionario.insert("perroaa");
		diccionario.insert("perrobb");
		diccionario.insert("perrocc");
		diccionario.insert("perrodd");

	}

	/* Método de inserción de una nueva palabra en el diccionario */
	public void insert(String word) {
		/* Insertamos la palabra a partir del nodo raíz del árbol */

		insertInTree(word, this.dict);

	}

	/* Método privado llamado por el anterior */
	private void insertInTree(String word, GTreeIF<Node> node) {

		GTreeIF<Node> nuevo = new GTree<Node>();
		//GTreeIF<Node> nodoHijo = new GTree<Node>();
		
		if ((node.getNumChildren() > 0) && (word.length() > 0)) {

			for (int i = 1; (i <= node.getNumChildren() && word.length() > 0); i++) {

				if (node.getChild(i).getRoot().getNodo().equals(String.valueOf(word.charAt(0)))) {

					nuevo = node.getChild(i);
					insertInTree(word.substring(1), nuevo);

				} else {

					nuevo.setRoot(new LetterNode(String.valueOf(word.charAt(0))));
					node.addChild((node.getNumChildren() + 1), nuevo);
					insertInTree(word.substring(1), nuevo);
				}

			}
		}
		if ((node.getNumChildren() == 0) && (word.length() > 0))

		{
			nuevo.setRoot(new LetterNode(String.valueOf(word.charAt(0))));
			node.addChild((node.getNumChildren() + 1), nuevo);
			insertInTree(word.substring(1), nuevo);
		}
		if (word.length() == 0) {

			nuevo.setRoot(new WordNode());
			node.addChild((node.getNumChildren() + 1), nuevo);

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
		// ...
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
		// ...
	}

	/*
	 * private void insertInTreeOriginal(String word, GTreeIF<Node> node) {
	 * 
	 * GTree<Node> nuevo = new GTree<Node>();
	 * 
	 * if (word.length() == 0) {
	 * 
	 * nuevo.setRoot(new WordNode()); node.addChild((node.getNumChildren() + 1),
	 * nuevo);
	 * 
	 * } else {
	 * 
	 * nuevo.setRoot(new LetterNode(word.charAt(0)));
	 * node.addChild((node.getNumChildren() + 1), nuevo);
	 * insertInTree(word.substring(1), nuevo);
	 * 
	 * }
	 * 
	 * }
	 */

}
