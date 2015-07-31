package bz.dojos.anagram;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class LocalDictionaryProvider implements DictionaryProvider {
	private Set<String> result;

	public LocalDictionaryProvider() {
		result = new HashSet<>();
	}

	@Override
	public Set<String> get() {
		if (result.isEmpty()) {
			try {
				Files.lines(
						Paths.get(getClass().getResource("/wordlist.txt")
								.toURI()), Charset.forName("UTF-8")).forEach(
						result::add);

			} catch (IOException | URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}
}