package kwicSys;

import java.util.*;

public class RequiredWords {
	private HashSet<String> requiredWords;
	private static RequiredWords instance;
	
	private RequiredWords(){
		this.requiredWords = new HashSet<String>();
	}
	
	public static RequiredWords getRequiredWords(){
		if(instance == null){
			instance = new RequiredWords();
		}
		
		return instance;
	}
	
	public void addRequiredWords(String word){
		if(word != null){
			this.requiredWords.add(word);
		}
	}
	
	public void deleteRequiredWords(String word){
		if(word != null){
			this.requiredWords.remove(word);
		}
	}
	
	public boolean isRequiredWords(String word){
		if(word != null);
		return this.requiredWords.contains(word);
	}

}
