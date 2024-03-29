package es.uned.lsi.eped.pract2019_2020;

public class RootNode extends Node {

	private String nodo;

	public RootNode() {
		nodo = "RW";
	}

	@Override
	public NodeType getNodeType() {

		return NodeType.ROOTNODE;
	}

	public String getNodo() { // nos da el valor del nodo
		return nodo;
	}

	@Override
	public String toString() {
		return "RootNode [nodo=" + nodo + "]";
	}

}
