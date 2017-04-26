package console.sort.writer;

import java.io.IOException;
import java.util.List;

import console.sort.model.NameScore;

public interface ModelWriter {
	public void writeValues(List<? extends NameScore> values) throws IOException;
}
