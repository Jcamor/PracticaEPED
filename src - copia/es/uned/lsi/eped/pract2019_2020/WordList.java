package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class WordList {
	private ListIF<WordListN> wordList;

	public WordList() {
		this.wordList = new List<WordListN>();
	}

	public void add(String word) {
		int tamanio = word.length();
		boolean encontrado = false;
		boolean menor = true;

		if (wordList.size() != 0) {

			for (int i = 1; i <= wordList.size(); i++) {
				if (wordList.get(i).getWordSize() == tamanio) {
					wordList.get(i).add(word);
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				for (int i = 1; i <= wordList.size(); i++) {
					if (wordList.get(i).getWordSize() < tamanio) {
						wordList.insert(i, new WordListN(tamanio));
						wordList.get(i).add(word);
						menor = false;
						break;
					}
				}
				if (menor) {
					int pos = wordList.size() + 1;
					wordList.insert(pos, new WordListN(tamanio));
					wordList.get(pos).add(word);
				}
			}

		} else

		{
			wordList.insert(1, new WordListN(tamanio));
			wordList.get(1).add(word);
		}

	}

	public String toString() {
		StringBuilder salida = new StringBuilder();
		for (int pos = 1; pos <= this.wordList.size(); pos++) {
			salida.append(this.wordList.get(pos).toString());
		}
		return salida.toString();
	}
}
