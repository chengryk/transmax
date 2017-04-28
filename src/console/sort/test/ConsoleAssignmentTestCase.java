package console.sort.test;

import org.junit.Test;

import console.sort.ConsoleAssignment;
import junit.framework.TestCase;

public class ConsoleAssignmentTestCase extends TestCase {

	@Test
	public void testOutputFilePath() {
		String inputFilePath = "testFile.csv";
		String expectedOutputFilePath = "testFile-graded.csv";
		ConsoleAssignment value = new ConsoleAssignment(inputFilePath);
		assertEquals(expectedOutputFilePath, value.getOutputFilePath());
	}

}
