package console.sort.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import console.sort.model.NameScore;
import console.sort.reader.ModelReader;
import console.sort.reader.NameScoreReader;
import junit.framework.TestCase;

public class NameScoreReaderTestCase extends TestCase {
	@Test
	public void testProvidedExample() {
		ModelReader reader = new NameScoreReader("txt\\providedExample.txt");
		List<? extends NameScore> values = null;
		try {
			values = reader.readValues();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(values);
		if (values != null){
			assertEquals(4, values.size());
			List<NameScore> expected = new ArrayList<NameScore>();
			
			expected.add(new NameScore("BUNDY, TERESSA, 88"));
			expected.add(new NameScore("SMITH, ALLAN, 70"));
			expected.add(new NameScore("KING, MADISON, 88"));
			expected.add(new NameScore("SMITH, FRANCIS, 85"));
			
			for (int i=0;i<4;i++){
				assertEquals(0, expected.get(i).compareTo(values.get(i)));
			}
		}
	}
}
