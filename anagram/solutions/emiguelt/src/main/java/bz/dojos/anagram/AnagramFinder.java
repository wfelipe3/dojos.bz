package bz.dojos.anagram;

import java.util.*;

public class AnagramFinder {

	private AnagramIndex index;

    public AnagramFinder(AnagramIndex index) {
    	this.index = index;
    }

    List<String> findAnagrams(String word) {
    	List<String> list = index.getList(word);
		list.removeIf(s -> word == s);
		return list;
    }


}