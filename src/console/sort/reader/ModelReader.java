package console.sort.reader;

import java.io.IOException;
import java.util.List;

import console.sort.model.NameScore;

public interface ModelReader {
	public List<? extends NameScore> readValues() throws IOException;
}
