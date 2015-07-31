package bz.dojos.anagram;

import java.util.Collections;
import java.util.Set;

public interface DictionaryProvider {
	default Set<String> get(){
		return Collections.emptySet();
	}
}
