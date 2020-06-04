package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class WordList {
	private ListIF<WordListN> wordList;
	
	
	public WordList() {
Main.WORDLISTCREADA = true;

		this.wordList = new List<WordListN>();
	}
	
	public void add(String word) { //No lo tengo claro y creo q no es asi 

		WordListN listaPalabras = new WordListN(word.length());
		listaPalabras.add(word);
		wordList.insert(wordList.size()+1,listaPalabras);
		
	}
	
	public String toString() {
		StringBuilder salida = new StringBuilder();
		for ( int pos = 1 ; pos <= this.wordList.size() ; pos++ ) {
			salida.append(this.wordList.get(pos).toString());
		}
		return salida.toString();
	}
}
