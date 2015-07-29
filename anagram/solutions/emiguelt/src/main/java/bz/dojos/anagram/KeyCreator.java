package bz.dojos.anagram;

public class KeyCreator {
	
	public String  getKey(String str){
		WordDecomposer dc = new WordDecomposer();
		return dc.join(dc.sort(dc.split(str)));
		
	}
}
