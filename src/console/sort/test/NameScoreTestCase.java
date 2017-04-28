package console.sort.test;

import org.junit.Test;

import console.sort.model.NameScore;
import junit.framework.TestCase;

public class NameScoreTestCase extends TestCase {

	@Test
	public void testFormatCorrect() {
		String surname = "BUNDY";
		String name = "TERESSA";
		float score = 88;
		String rawString = surname + ", " + name + ", " + score;
		NameScore value = new NameScore(rawString);
		assertTrue(value.isValid());
		assertEquals(surname, value.getSurname());
		assertEquals(name, value.getName());
		assertEquals(rawString, value.getRawString());
		assertEquals(score, value.getScore());
	}

	@Test
	public void testFormatManyNames() {
		String surname = "BUNDY";
		String name = "TERESSA, ALICE";
		float score = 88;
		String rawString = surname + ", " + name + ", " + score;
		NameScore value = new NameScore(rawString);
		assertTrue(value.isValid());
		assertEquals(surname, value.getSurname());
		assertEquals(name, value.getName());
		assertEquals(rawString, value.getRawString());
		assertEquals(score, value.getScore());
	}

	@Test
	public void testFormatMissingName() {
		String rawString = "BUNDY, 88";
		NameScore value = new NameScore(rawString);
		assertFalse(value.isValid());
	}
	
	@Test
	public void testFormatNoFields() {
		String rawString = ", ";
		NameScore value = new NameScore(rawString);
		assertFalse(value.isValid());
	}
	
	@Test
	public void testFormatScoreMissing() {
		String rawString = "BUNDY, TERESSA, ";
		NameScore value = new NameScore(rawString);
		assertFalse(value.isValid());
	}
	
	@Test
	public void testFormatScoreInvalid() {
		String rawString = "BUNDY, TERESSA, A";
		NameScore value = new NameScore(rawString);
		assertFalse(value.isValid());
	}
	
	@Test
	public void testMethodCompareToDifferentScore() {
		String surname1 = "BUNDY";
		String name1 = "TERESSA";
		float score1 = 88;
		String rawString1 = surname1 + ", " + name1 + ", " + score1;
		NameScore value1 = new NameScore(rawString1);
		
		String surname2 = "MUNDY";
		String name2 = "TESSA";
		float score2 = 9;
		String rawString2 = surname2 + ", " + name2 + ", " + score2;
		NameScore value2 = new NameScore(rawString2);
		assertTrue(value1.compareTo(value2) < 0);
		assertTrue(value2.compareTo(value1) > 0);
	}
	
	@Test
	public void testMethodCompareToSameScore() {
		String surname1 = "BUNDY";
		String name1 = "TERESSA";
		float score1 = 88;
		String rawString1 = surname1 + ", " + name1 + ", " + score1;
		NameScore value1 = new NameScore(rawString1);
		
		String surname2 = "MUNDY";
		String name2 = "TESSA";
		float score2 = 88;
		String rawString2 = surname2 + ", " + name2 + ", " + score2;
		NameScore value2 = new NameScore(rawString2);
		
		assertTrue(value1.compareTo(value2) < 0);
		assertTrue(value2.compareTo(value1) > 0);
	}
}
