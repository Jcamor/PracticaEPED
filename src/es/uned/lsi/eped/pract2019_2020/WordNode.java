package es.uned.lsi.eped.pract2019_2020;

public class WordNode extends Node {

	private String nodo;
	
	public WordNode() {
		nodo = "WN";
	}
    
	public String getNodo() {
		return nodo;
	}
	
    @Override
    public NodeType getNodeType() {
       
        return NodeType.WORDNODE;
    
    }

	@Override
	public String toString() {
		return "WordNode [nodo=" + nodo + "]";
	}
}
