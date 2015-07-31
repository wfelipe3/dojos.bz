package bz.dojos.anagram;

import static org.junit.Assert.*;

import org.junit.Test;

public class KeyCreatorTest {

	@Test
	public void givenAString_returnSortStringByCharsAsending() {
		KeyCreator creator = new KeyCreator();
		assertEquals("aabce", creator.getKey("bcaea"));
		assertEquals("egilmu", creator.getKey("miguel"));
		assertEquals("", creator.getKey(""));
		assertEquals("", creator.getKey(null));
	}

}
