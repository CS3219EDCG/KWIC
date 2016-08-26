package kwic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter movie titles: ");

        List<String> inputs = new ArrayList<String>();
        String userInput = sc.nextLine();
        while (!userInput.isEmpty()) {
            inputs = Arrays.asList(userInput.split(", "));
            userInput = sc.nextLine();
        }

        System.out.println("Enter words to ignore: ");
        String inputWordToIgnore = sc.nextLine();
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        while (!inputWordToIgnore.isEmpty()) {
        	String[] wordsToIgnoreArr = inputWordToIgnore.split(", ");
        	for(int i=0; i < wordsToIgnoreArr.length; i++){
        		wordsToIgnore.addWordToIgnore(wordsToIgnoreArr[i]);
        	}
            inputWordToIgnore = sc.nextLine();
        }

        Alphabetizer alphabetizer = new Alphabetizer();
        for (String str : inputs) {
            CircularShift shifter = new CircularShift(str);
            alphabetizer.addLines(shifter.getCircularShifts());
        }

        String[] result = alphabetizer.getSortedLines();
        StringBuilder builder = new StringBuilder();
        String separator = System.lineSeparator();
        for (String str : result) {
            builder.append(str).append(separator);
        }
        System.out.print(builder.toString());

        long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) );
        System.exit(0);
    }
}
