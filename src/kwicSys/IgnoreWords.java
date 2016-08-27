package kwicSys;

import java.util.*;

public class IgnoreWords {
	//Use HashSet to eliminate duplicates
	private HashSet<String> ignoreWords;
	private static IgnoreWords instance;
	
	private IgnoreWords(){
		this.ignoreWords = new HashSet<String>();
	}
	
	public static IgnoreWords getIgnoreWords(){
		if(instance == null){
			instance = new IgnoreWords();
		}
		
		return instance;
	}
	
	public void addIgnoreWords(String word){
		if(word != null){
			this.ignoreWords.add(word);
		}
	}
	
	public void deleteIgnoreWords(String word){
		if(word != null){
			this.ignoreWords.remove(word);
		}
	}
	
	public boolean isIgnoreWords(String word){
		if(word != null);
		return this.ignoreWords.contains(word);

	}

}
