package console.sort;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import console.sort.model.NameScore;
import console.sort.reader.ModelReader;
import console.sort.reader.NameScoreReader;
import console.sort.writer.ModelWriter;
import console.sort.writer.NameScoreWriter;

public class ConsoleAssignment {
	private String inputFilePath;
	private String outputFilePath;
	public ConsoleAssignment(String inputFilePath){
		this.inputFilePath = inputFilePath;
		int extIndex = inputFilePath.lastIndexOf(".txt");
		outputFilePath = (extIndex>0?inputFilePath.substring(0, extIndex):inputFilePath) + "-graded.txt";
	}
	
	public String getInputFilePath(){
		return inputFilePath;
	}
	
	public String getOutputFilePath(){
		return outputFilePath;
	}

	
	public void run(){
		ModelReader reader = new NameScoreReader(inputFilePath);
		try {
			List<? extends NameScore> values = reader.readValues();
			Collections.sort(values);
			ModelWriter writer = new NameScoreWriter(outputFilePath);
			writer.writeValues(values);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if (args != null && args.length > 1){
			if (!StringUtils.isBlank(args[1])){
				ConsoleAssignment console = new ConsoleAssignment(args[1]);
				console.run();
			}
		}
	}
}
