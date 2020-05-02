package es.uned.lsi.eped.pract2019_2020;

import java.util.Scanner;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;

public class Dictionary {

	protected GTree<Node> dict; /* El diccionario es un árbol general de nodos */
	private char c;

	/* Constructor de la clase */
	public Dictionary() {
		this.dict = new GTree<Node>();
		this.dict.setRoot(new RootNode());
	}

	public static void main(String[] args) {
		Dictionary diccionario = new Dictionary();
		// diccionario.insert("");
		diccionario.insert("perroa1");
		diccionario.insert("perrob2");
		diccionario.insert("perroc3");
		diccionario.insert("perrod4");

	}

	/* Método de inserción de una nueva palabra en el diccionario */
	public void insert(String word) {
		/* Insertamos la palabra a partir del nodo raíz del árbol */
		System.out.println(word.length());
		System.out.println(word);

		insertInTree(word, this.dict);

		visualizar(this.dict, word);
		for (int i = 1; i <= dict.getFanOut(); i++) {
			System.out.println(dict.getFanOut());
			System.out.println(dict.getRoot());
			System.out.println(dict.getChild(i).getRoot());
			System.out.println(dict.getChild(i).getChild(1).getRoot());
			System.out.println(dict.getChild(i).getChild(1).getChild(1).getRoot());
			System.out.println(dict.getChild(i).getChild(1).getChild(1).getChild(1).getRoot());
			System.out.println(dict.getChild(i).getChild(1).getChild(1).getChild(1).getChild(1).getRoot());
			System.out.println(dict.getChild(i).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getRoot());
			System.out.println(
					dict.getChild(i).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getRoot());
			System.out.println(dict.getChild(i).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1).getChild(1)
					.getChild(1).getRoot());
		}
	}

	/* Método privado llamado por el anterior */
	private void insertInTree(String word, GTreeIF<Node> node) {

		GTree<Node> nuevo = new GTree<Node>();
		String entradaTeclado;
		Scanner entradaEscaner = new Scanner (System.in);
		// System.out.println(node.getFanOut());

		if (word.length() != 0) {
			if (node.getNumChildren() != 0) {
				System.out.println("Estoy en hijo != 0");
				System.out.println(node.getNumChildren()+" numero de hijos");
				
				for (int i = 1; i <= node.getNumChildren() && word.length() != 0; i++) {
				
					if ((boolean) node.getChild(i).getRoot().equals(word.charAt(0))) {
						insertInTree(word.substring(1), node.getChild(i));
						System.out.println("Estoy en hijo igual q letra" + i);
						 
						 entradaTeclado = entradaEscaner.nextLine (); 
					} else {
						nuevo.setRoot(new LetterNode(word.charAt(0)));
						node.addChild((node.getNumChildren() + 1), nuevo);
						insertInTree(word.substring(1), nuevo);
						System.out.println("Estoy en hijo distinto que la letra " + i);
						entradaTeclado = entradaEscaner.nextLine (); 
					}
				}
			}
			if (node.getNumChildren() == 0) {
				nuevo.setRoot(new LetterNode(word.charAt(0)));
				node.addChild((node.getNumChildren() + 1), nuevo);
				System.out.println("Estoy hijo 0 delante de la recursividad");
				insertInTree(word.substring(1), nuevo);
				System.out.println("Estoy en hijo = 0");
				entradaTeclado = entradaEscaner.nextLine (); 
			}
		} else {
			nuevo.setRoot(new WordNode());
			node.addChild((node.getNumChildren() + 1), nuevo);
			System.out.println("Estoy en word = 0");
			entradaTeclado = entradaEscaner.nextLine (); 

		}

	}

	public void visualizar(GTreeIF<Node> node, String word) {
		System.out.println();
		System.out.println("Usamos node-------------------");
		System.out.println(node.getNumChildren() + " numero de hijos");
		System.out.println(node.isLeaf() + " es hoja");

		if (node.getNumChildren() > 0) {
			System.out.println(node.getChild(1).getRoot() + " hijo posición " + 1);
		}
		System.out.println(word + " palabra que entra ");
		System.out.println(node.getRoot().toString());
		System.out.println(node.getHeight() + " Altura del arbol");
		System.out.println();

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

	private void insertInTreeOriginal(String word, GTreeIF<Node> node) {

		GTree<Node> nuevo = new GTree<Node>();

		if (word.length() == 0) {

			nuevo.setRoot(new WordNode());
			node.addChild((node.getNumChildren() + 1), nuevo);

		} else {

			nuevo.setRoot(new LetterNode(word.charAt(0)));
			node.addChild((node.getNumChildren() + 1), nuevo);
			insertInTree(word.substring(1), nuevo);

		}

	}

}
