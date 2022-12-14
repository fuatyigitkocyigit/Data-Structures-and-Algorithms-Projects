//-----------------------------------------------------
// Title: Functions Class
// Authors: Baris Sinapli / Fuat Yigit Kocyigit
// ID: 38039235216 / 16429085948
// Section: 1 / 2
// Assignment: 5
// Description: This class contains methods that perform the functions requested in the assignment.
//-----------------------------------------------------
public class Functions {
	
	private TST<Integer> trie;
	
	public Functions() {}
	
	public Functions(TST<Integer> trie) {
		this.setTrie(trie);
	}
	

	public boolean Search(String arg) {
		return trie.contains(arg);
	}
	
	public void autoComplete(String prefix) {
		String autoCompletedWords = String.join(", ", trie.keysWithPrefix(prefix));
		if(!autoCompletedWords.isEmpty())
			System.out.println(autoCompletedWords);
		else
			System.out.println("No word");
	}
	
	public void reverseAutoComplete(String suffix) {
		String autoCompletedWords = "";
		for(int i=0; i<256; i++) {
			StringBuilder dot = new StringBuilder("."); 
			for(int j=i; j>0; j--) {
				dot = dot.append(".");
			}
			String tempWords = String.join(", ", trie.keysThatMatch(dot.toString() + suffix));
			if(!tempWords.isEmpty())
				if(autoCompletedWords.isEmpty())
					autoCompletedWords += tempWords;
				else
					autoCompletedWords = autoCompletedWords + ", " + tempWords;
		}
		if(!autoCompletedWords.isEmpty())
			System.out.println(autoCompletedWords);
		else
			System.out.println("No word");
	}
	
	public void FullAutoComplete(String prefix, String suffix) {
		String autoCompletedFullWord = String.join(", ", trie.keysThatMatch(prefix + "." + suffix));
		if(!autoCompletedFullWord.isEmpty())
			System.out.println(autoCompletedFullWord);
		else
			System.out.println("No word");
	}
	
	public void findTopK(int k) {
		String topKWords = String.join(", ", trie.getFrequency(k));
		if(!topKWords.isEmpty())
			System.out.println(topKWords);
		
	}
	
	public void SolvePuzzle(String filepath) {
		
	}

	public void setTrie(TST<Integer> trie) {
		this.trie = trie;
	}
}
