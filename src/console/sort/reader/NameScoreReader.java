package console.sort.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import console.sort.model.NameScore;

public class NameScoreReader implements ModelReader {
	private String inputFilePath;
	public NameScoreReader (String inputFilePath){
		this.inputFilePath = inputFilePath;
	}
	@Override
	public List<? extends NameScore> readValues() throws IOException {
		File inputFile = new File(inputFilePath);
		List<String> lines = FileUtils.readLines(inputFile, StandardCharsets.UTF_8);
		List<NameScore> values = new ArrayList<NameScore>();
		NameScore nameScore;
		for (String line:lines){
			if (!StringUtils.isBlank(line)){
				nameScore = new NameScore(line);
				values.add(nameScore);
			}
		}
		return values;
	}

}
