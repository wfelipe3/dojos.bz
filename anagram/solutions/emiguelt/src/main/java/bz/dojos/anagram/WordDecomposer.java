package bz.dojos.anagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordDecomposer {
	public List<Character> split(String str) {
		List<Character> result = Collections.emptyList();
		if (!stringIsEmpty(str)) {
			result = new ArrayList<>();
			for (int i = 0; i < str.length(); i++) {
				result.add(str.charAt(i));
			}
		}
		return result;
	}

	private boolean stringIsEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public List<Character> sort(List<Character> chars) {
		List<Character> result = Collections.emptyList();
		if(!chars.isEmpty()){
			result = new ArrayList<>(chars);
			result.sort((a,b)-> a-b);
		}
		return result;
	}

	public String join(List<Character> chars) {
		return null;
	}
}
