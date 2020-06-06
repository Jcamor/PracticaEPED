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

	
	public String getNodo() {
		
		return nodo;
	}
	
        
	public String toString() {
		return "LetterNode [nodo=" + nodo + "]";
	}
        
}
