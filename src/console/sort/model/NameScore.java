package console.sort.model;

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
			String[] segments = rawString.trim().split(",");
			if (segments.length > 2){
				String scoreString = segments[segments.length-1];
				if (!StringUtils.isBlank(scoreString)){
					try {
						score = Float.parseFloat(scoreString);
						surname = segments[0];
						StringBuffer nameBuffer = new StringBuffer();
						for (int i=1;i<segments.length-1;i++){
							nameBuffer.append(segments[i]);
						}
						name = nameBuffer.toString();
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
	
	@Override
	public String toString() {
		return isValid?rawString:surname + ", " + name + ", " + score;
	}

	@Override
	public int compareTo(NameScore arg) {
		return this.isValid && arg.isValid?
				(int)(getScore()-arg.getScore()):toString().compareTo(arg.toString());
	}
}
