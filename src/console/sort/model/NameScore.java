package console.sort.model;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class NameScore implements Comparable<NameScore>{
	private String surname, name;
	private float score;
	private String rawString;
	private boolean isValid = false;
	
	public NameScore(String inputString){
		rawString = inputString;
		parseFields();
	}
	
	// protected to allow for bypass or override if NameScore is extended
	protected void parseFields(){
		if (!StringUtils.isBlank(rawString)){
			String[] segments = rawString.split(",");
			if (segments.length > 2){
				String scoreString = segments[segments.length-1].trim();
				if (!StringUtils.isBlank(scoreString)){
					try {
						score = Float.parseFloat(scoreString);
						surname = segments[0].trim();
						int scoreIndex = rawString.lastIndexOf(",");
						name = rawString.substring(segments[0].length() + 1, scoreIndex).trim();
						isValid = true;					
					} catch (NumberFormatException ignored){}
				}
			}
		}
	}
	
	public boolean isValid(){
		return this.isValid;
	}
	
	public float getScore(){
		return score;
	}
	
	public String getSurname(){
		return surname; 
	}
	
	public String getName(){
		return name; 
	}
	
	public String getRawString(){
		return rawString; 
	}
	
	@Override
	public String toString() {
		return isValid?rawString:surname + ", " + name + ", " + score;
	}

	@Override
	public int compareTo(NameScore arg) {
		int ret = 0;
		if (isValid && arg.isValid){
			float temp = getScore() - arg.getScore(); 
			if (temp < 0){
				ret = 1;
			} else if (temp > 0){
				ret = -1;
			} 
		} else if (isValid){
			ret = 1;
		} else if (arg.isValid){
			ret = -1;
		}
		if (ret == 0){
			ret = toString().compareTo(arg.toString());
		}
		
		return ret;
	}
}
