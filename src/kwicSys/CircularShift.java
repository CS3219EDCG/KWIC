package kwicSys;

import java.util.*;

public class CircularShift {

	private String title;
	private IgnoreWords ignoreWord;
	
	public CircularShift(String input){
		if(input != null);
		this.title = input.toLowerCase();
		this.ignoreWord = IgnoreWords.getIgnoreWords();
	}
	
	public String[] getCircularShift(){
		String[] wordArr = this.title.split(" ");
		String[] shiftedTitle = new String[wordArr.length];
		shiftedTitle[0] = this.title;
		
		for(int i = 1; i < wordArr.length; i++){
			shiftedTitle[i] = this.getShiftedTitle(i, wordArr);
		}
		
		String[] filterShiftedTitle = getShiftedTitleWithoutIgnoreWords(shiftedTitle);
		for(int i = 0; i < filterShiftedTitle.length; i++){
			filterShiftedTitle[i] = maintainCapitalization(filterShiftedTitle[i]);
		}
		
		return filterShiftedTitle;
	}
	
	private String getShiftedTitle(int index, String[] inputArr){
		StringBuilder builder = new StringBuilder();
		
		for(int i = index; i < inputArr.length; i++){
			builder.append(inputArr[i] + " ");
		}
		
		for(int i = 0; i < index; i++){
			builder.append(inputArr[i] + " ");
		}
		
		if(builder.length() > 0){
			builder.deleteCharAt(builder.length() - 1);
		}
		
		return builder.toString();
	}
	
	private String[] getShiftedTitleWithoutIgnoreWords(String[] inputArr){
		List<String> shiftedTitleList = new ArrayList<String>(Arrays.asList(inputArr));
		
		Iterator<String> itr = shiftedTitleList.iterator();
		while(itr.hasNext()){
			String firstWord = itr.next().split(" ")[0];
			if(this.ignoreWord.isIgnoreWords(firstWord)){
				itr.remove();
			}
		}
		
		return shiftedTitleList.toArray(new String[shiftedTitleList.size()]);
	}
	
	private String maintainCapitalization(String input){
		String[] wordArr = input.split(" ");
		StringBuilder builder = new StringBuilder();
		
		for(String str: wordArr){
			if(this.ignoreWord.isIgnoreWords(str)){
				builder.append(str + " ");
			}else{
				builder.append(Character.toUpperCase(str.charAt(0)));
				builder.append(str.substring(1) + " ");
			}
		}
		
		if(builder.length() > 0){
			builder.deleteCharAt(builder.length() -1);
		}
		
		return builder.toString();
	}
}
