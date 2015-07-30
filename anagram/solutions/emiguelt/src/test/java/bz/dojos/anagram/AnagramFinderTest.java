package bz.dojos.anagram;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by WilliamE on 23/07/2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class AnagramFinderTest {
	
	@Mock
	private AnagramIndex index;
	
	
    private AnagramFinder anagram;
    
    @Before
    public void setup(){
    	anagram= new AnagramFinder(index);
    }

    @Test
    public void givenEmptyStringThenReturnEmptyList() {
        assertEmptyAnagram("");
    }

    @Test
    public void givenOneLetterWord_ThenReturnEmptyList() {
        assertEmptyAnagram("a");
    }

    @Test
    public void givenTwoLetterWord_with_anagrams_ThenReturnAnAnagram() {
        assertAnagrams("ay", "ya");
        assertAnagrams("ya", "ay");
    }

    @Test
    public void givenAWordWithTwoLetter_WhenDoesNotHaveAnagrams_ThenReturnEmpty() {
        assertEmptyAnagram("ey");
    }

    @Test
    public void givenAWordWithThreeLetters_WhenHaveOneAnagram_ThenReturnAnAnagram() {
        assertAnagrams("los","sol");
    }

    private void assertAnagrams(String word, String... expected) {
    	List<String> list = new ArrayList<>(Arrays.asList(expected));
    	list.add(word);
    	when(index.getList(word)).thenReturn(list);
        List<String> anagrams= anagram.findAnagrams(word);
        Assert.assertThat(anagrams, CoreMatchers.hasItems(expected));
    }

    private void assertEmptyAnagram(String word) {
        List<String> anagrams= anagram.findAnagrams(word);
        Assert.assertEquals(0, anagrams.size());
    }

}
