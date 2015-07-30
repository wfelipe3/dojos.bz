package bz.dojos.anagram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnagramIndexTest {

	@Mock
	private KeyCreator keyCreator;
	@Mock
	private DictionaryProvider provider;
	
	private AnagramIndex index;

	@Before
	public void setup() {
		index = new AnagramIndex(keyCreator);
	}

	@Test
	public void givenNotFoundKey_ReturnEmptyList() {
		assertTrue(index.getList("abc").isEmpty());
	}

	@Test
	public void givenOneWordDictionary_thenReturnListWithKeys() {
		assertGetList(strArray("abc"), intArray(1));
	}
	
	@Test
	public void givenTwoWordDictionary_thenReturnListWithKeys() {
		assertGetList(strArray("abc", "acb"), intArray(2,2));
		assertGetList(strArray("abc", "abb"), intArray(1,1));
	}
	
	@Test
	public void givenThreeWordDictionary_thenReturnListWithKeys() {
		assertGetList(strArray("abc", "acb", "bca"), intArray(3,3,3));
		assertGetList(strArray("abc", "abb", "bca"), intArray(2,1,2));
		assertGetList(strArray("abc", "abb", "aca"), intArray(1,1,1));
		assertGetList(strArray("abc", "aac", "aca"), intArray(1,2,2));
		assertGetList(strArray("abc", "acb", "aca"), intArray(2,2,1));
	}


	private void assertGetList(String[] str, int[] sizeExpected) {
		when(keyCreator.getKey(anyString())).thenCallRealMethod();
		when(provider.get()).thenReturn(new HashSet<>(Arrays.asList(str)));
		index.load(provider);

		for (int i = 0; i < str.length; i++) {
			assertEquals(sizeExpected[i], index.getList(str[i]).size());
		}

//		verify(keyCreator, VerificationModeFactory.times(str.length*2)).getKey(str);
	}

	private int[] intArray(int... expected) {
		return expected;
	}

	private String[] strArray(String... string) {
		return string;
	}

}
