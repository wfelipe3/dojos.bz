package bz.dojos.anagram;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class WordDecomposerTest {

	private WordDecomposer decomposer;

	@Before
	public void setup() {
		decomposer = new WordDecomposer();
	}

	@Test
	public void givenEmptyString_thenReturnEmptyList() {
		assertTrue(split(null).isEmpty());
		assertTrue(split("").isEmpty());
	}

	private List<Character> split(String a) {
		return decomposer.split(a);
	}

	@Test
	public void givenOneCharString_thenReturnOneSizeListContainingChar() {
		assertSplit("a"); 
		assertSplit("b"); 
		assertSplit("c"); 
		assertSplit(" "); 
	}

	@Test
	public void givenTwoCharString_thenReturnTwoSizeListContainingChars() {
		assertSplit("ab"); 
		assertSplit("bc"); 
		assertSplit("cd"); 
		assertSplit(" a"); 
	}
	
	@Test
	public void givenThreeCharString_thenReturnThreeSizeListContainingChars() {
		assertSplit("abc"); 
		assertSplit("bcd"); 
		assertSplit("cde"); 
		assertSplit(" ab"); 
	}

	private void assertSplit(final String word) {
		List<Character> chars = split(word);
		assertEquals(word.length(), chars.size());
		chars.forEach(ch -> {
			if (!word.contains(ch + ""))
				fail("word not found");
		});
	}

}
