package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;

public class Dictionary {

	protected GTree<Node> dict; /* El diccionario es un árbol general de nodos */

	/* Constructor de la clase */
	public Dictionary() {
		this.dict = new GTree<Node>();
		this.dict.setRoot(new RootNode());
	}

	public static void main(String[] args) {
		Dictionary diccionario = new Dictionary();
		diccionario.insert("abcdefg");

	}

	/* Método de inserción de una nueva palabra en el diccionario */
	public void insert(String word) {
		/* Insertamos la palabra a partir del nodo raíz del árbol */
		System.out.println(word.length());

		// while (word.length() > 0) {

		System.out.println(word);
		insertInTree(word, this.dict);
		visualizar(this.dict, word);
		System.out.println(dict.getFanOut());
		System.out.println(dict.getRoot());
		System.out.println(dict.getChild(1).getRoot());
		System.out.println(dict.getChild(1).getChild(1).getRoot());
		System.out.println(dict.getChild(1).getChild(1).getChild(1).getRoot());
		System.out.println(dict.getChild(1).getChild(1).getChild(1).getChild(1).getRoot());
		System.out.println(dict.getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getRoot());
		System.out.println(dict.getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getRoot());
		System.out.println(dict.getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getRoot());
		System.out.println(dict.getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getRoot());
	}

	/* Método privado llamado por el anterior */
	private void insertInTree(String word, GTreeIF<Node> node) {
		GTree<Node> nuevo = new GTree<Node>();
		if (word.length() == 0) {
			nuevo.setRoot(new WordNode());
			node.addChild((node.getNumChildren() + 1), nuevo);
		} else {
			nuevo.setRoot(new LetterNode(word.charAt(0)));
			node.addChild((node.getNumChildren() + 1), nuevo);
			insertInTree(word.substring(1), nuevo);
		}

		
		
	
	// word = word.substring(1);

	// node = node.getChild(1);
	visualizar(node, word);

		// while (word.length() > 0) {
		/*
		 * GTree<Node> hTree = new GTree<Node>(); hTree.setRoot(new
		 * LetterNode(word.charAt(0))); GTree<Node> oTree = new GTree<Node>();
		 * oTree.setRoot(new LetterNode(word.charAt(1))); GTree<Node> lTree = new
		 * GTree<Node>(); lTree.setRoot(new LetterNode(word.charAt(2)));
		 * 
		 * sizehijo = oTree.getNumChildren() + 1; oTree.addChild(sizehijo, lTree);
		 * 
		 * sizehijo = hTree.getNumChildren() + 1; hTree.addChild(sizehijo, oTree);
		 * 
		 * visualizar(hTree,word); visualizar(oTree,word); visualizar(lTree,word);
		 */
		// }

	}

	public void visualizar(GTreeIF<Node> node, /* GTreeIF<Node> hijoTree, */ String word) {
		System.out.println();
		System.out.println("Usamos node-------------------");
		System.out.println(node.getNumChildren() + " numero de hijos");
		System.out.println(node.isLeaf() + " es hoja");

		// for (int j = 1; j <= node.getNumChildren(); j++) {
		if (node.getNumChildren() > 0) {
			System.out.println(node.getChild(1).getRoot() + " hijo posición " + 1);
		}
		System.out.println(word + " palabra que entra ");
		System.out.println(node.getRoot().toString());
		System.out.println(node.getHeight() + " Altura del arbol");
		System.out.println();
		/*
		 * System.out.println("Usamos hijoTree-------------------");
		 * System.out.println(hijoTree.getNumChildren() + " numero de hijos");
		 * System.out.println(hijoTree.isLeaf() + " es hoja"); System.out.println(word +
		 * " palabra que entra "); System.out.println(hijoTree.getRoot().toString());
		 */

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

}
