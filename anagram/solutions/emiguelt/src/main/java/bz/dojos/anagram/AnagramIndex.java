package bz.dojos.anagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnagramIndex {
	private KeyCreator keyCreator;
	private Map<String, Set<String>> dictionary;

	public AnagramIndex(KeyCreator keyCreator) {
		this.keyCreator = keyCreator;
		this.dictionary = new HashMap<>();
	}

	public void load(DictionaryProvider provider) {
		dictionary.clear();

		provider.get().forEach(s -> {
			String key = keyCreator.getKey(s);
			Set<String> set = dictionary.get(key);
			if (set == null) {
				set = new HashSet<>();
				dictionary.put(key, set);
			}

			set.add(s);
		});
	}

	public List<String> getList(String key) {
		Set<String> words = dictionary.get(keyCreator.getKey(key));
		if (words == null) {
			return Collections.emptyList();
		}
		return new ArrayList<>(words);
	}
}
