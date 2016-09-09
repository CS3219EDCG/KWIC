package kwicSys;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String MESSAGE_TITLES = "Enter movie titles: ";
		final String MESSAGE_IGNORE = "Enter words to ignore: ";
		final String MESSAGE_REQUIRED = "Enter words required: ";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(MESSAGE_TITLES);
		List<String> titles = new ArrayList<String>();
		String input = sc.nextLine();
		while(!input.isEmpty()){
			titles = Arrays.asList(input.split(", "));
			input = sc.nextLine();
		}
		
		System.out.println(MESSAGE_IGNORE);
		String inputIgnore = sc.nextLine();
		IgnoreWords ignoreWords = IgnoreWords.getIgnoreWords();
		while(!inputIgnore.isEmpty()){
			String[] ignoreWordsArr = inputIgnore.split(", ");
			for(int i = 0; i < ignoreWordsArr.length; i++){
				ignoreWords.addIgnoreWords(ignoreWordsArr[i]);
			}
			inputIgnore = sc.nextLine();
		}
		
		//KWIC Extension
		System.out.println(MESSAGE_REQUIRED);
		String inputRequired = sc.nextLine();
		RequiredWords requiredWords = RequiredWords.getRequiredWords();
		while(!inputRequired.isEmpty()){
			String[] requiredWordsArr = inputRequired.split(", ");
			for(int i = 0; i < requiredWordsArr.length; i++){
				requiredWords.addRequiredWords(requiredWordsArr[i]);
			}
			inputRequired = sc.nextLine();
		}
		
		AlphabeticShift alphabeticShift = new AlphabeticShift();
		for(String str: titles){
			CircularShift shift = new CircularShift(str);
			alphabeticShift.addOutputLines(shift.getCircularShift());
		}
		
		String[] output = alphabeticShift.sortOutputLines();
		
		StringBuilder builder = new StringBuilder();
		for(String str: output){
			builder.append(str + "\n");
		}
		
		System.out.print(builder.toString());
		
		System.exit(0);
	}

}
