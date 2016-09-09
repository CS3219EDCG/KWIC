package kwicSys;

import java.util.*;

public class AlphabeticShift {

	private List<String> outputLines;
	
	public AlphabeticShift(){
		this.outputLines = new ArrayList<String>();
	}
	
	public void addOutputLines(String[] lines){
		for(String str: lines){
			this.outputLines.add(str);
		}
	}
	
	public String[] sortOutputLines(){
		Collections.sort(this.outputLines);
		return this.outputLines.toArray(new String[this.outputLines.size()]);
	}
}
