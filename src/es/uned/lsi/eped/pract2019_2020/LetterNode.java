package es.uned.lsi.eped.pract2019_2020;

public class LetterNode extends Node {

	private String nodo;

	public LetterNode(String c) {
		nodo = c;
	}

	@Override
	public NodeType getNodeType() {

		return NodeType.LETTERNODE;
	}

	public String getNodo() { // nos da el valor del nodo

		return nodo;
	}

	public String toString() {
		return "LetterNode [nodo=" + nodo + "]";
	}

}
