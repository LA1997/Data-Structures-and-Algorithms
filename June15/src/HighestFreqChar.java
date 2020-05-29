import java.util.ArrayList;
import java.util.HashMap;

public class HighestFreqChar {

	public static char highestFreqChar(String str) {
		
		HashMap<Character, Integer> freqs = new HashMap<>();
		int hfci = 0;
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(freqs.containsKey(ch))
				freqs.put(str.charAt(i),freqs.get(ch)+1);
			else
				freqs.put(str.charAt(i),1);
			
			if(freqs.get(ch) > freqs.get(str.charAt(hfci))) {
				hfci = i;
			}
		}
		System.out.println(freqs);
		return str.charAt(hfci);
	}
	public static void main(String[] args) {
		
		String str = "aabraakadabra";
		System.out.println(highestFreqChar(str));
	}

}
