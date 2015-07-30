package bz.dojos.anagram;

import java.util.List;


public class AnagramTest {

	public static void main(String[] args) {
		AnagramIndex index = new AnagramIndex(new KeyCreator());
		LocalDictionaryProvider dictionary = new LocalDictionaryProvider();
		index.load(dictionary);
		AnagramFinder finder = new AnagramFinder(index);

		dictionary.get().forEach(s -> find(s, finder));

	}

	private static void find(String word, AnagramFinder finder) {
		long start = System.nanoTime();
		List<String> result = finder.findAnagrams(word);
		System.out.println(System.nanoTime() - start + " : " + result.size() +  " : " +  word +  " : " + result);
	}
}
