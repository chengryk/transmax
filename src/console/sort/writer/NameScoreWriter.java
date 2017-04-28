package console.sort.writer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import console.sort.model.NameScore;

public class NameScoreWriter implements ModelWriter{
	private String outputFilePath;
	public NameScoreWriter (String outputFilePath){
		this.outputFilePath = outputFilePath;
	}
	@Override
	public void writeValues(List<? extends NameScore> values) throws IOException {
		if (StringUtils.isBlank(outputFilePath)){
			throw new IOException("Output file path not initialised");
		} else if (values == null || values.isEmpty()){
			System.out.println("No values provided");
		} else {
			File outputFile = new File(outputFilePath);
			if (outputFile.exists()){
				File renamedFile = new File(outputFilePath + "." + System.currentTimeMillis());
				FileUtils.moveFile(outputFile, renamedFile);
				System.out.println("File renamed to " + renamedFile);
			}
			
			for (NameScore value:values){
				if (value != null){
					if (value.isValid()){
						FileUtils.writeStringToFile(outputFile, value.toString() + "\n", StandardCharsets.UTF_8.name(), true);
					} else {
						System.out.println("Line ignored: " + value.toString());
					}
				}						
			}
		}
	}
}
