package es.uned.lsi.eped.pract2019_2020;

public class LetterNode extends Node {
    
	private char nodo;
	  
    public LetterNode(char c) {
		nodo = c;
	}

	@Override
    public NodeType getNodeType() {
    	
        return NodeType.LETTERNODE;
    }

	public char getNodo() {
		return nodo;
	}

	@Override
	public String toString() {
		return "LetterNode [nodo=" + nodo + "]";
	}
        
}
