import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Coded {

	static int getKey(Map<Integer, String> hashmap, String value) {
		for (Entry<Integer, String> entry : hashmap.entrySet()) {
			if (entry.getValue().equals(value)) {
				// System.out.println(entry.getKey());
				return entry.getKey();
			}
		}
		return -1;
	}

	static String CodedWord(String initial, Map<Integer, String> FirstPart, Map<Integer, String> SecondPart) {
		char[] word = initial.toCharArray();
		char[] coded = new char[word.length];
		int codeArray1, codeArray2, j = -1, ascii;
		for (char letter : word) {
			j += 1;
			ascii=(int)letter;
			if (ascii<65||(ascii>90&ascii<97)||ascii>122){				
				coded[j]=letter;
				continue;
			}
			codeArray1 = getKey(FirstPart, String.valueOf(Character.toLowerCase(letter)));
			codeArray2 = getKey(SecondPart, String.valueOf(Character.toLowerCase(letter)));

			if (codeArray1 == -1)
				coded[j] = FirstPart.get(codeArray2).toCharArray()[0];
			if (codeArray2 == -1)
				coded[j] = SecondPart.get(codeArray1).toCharArray()[0];
		}
		String codedWord = new String(coded);
		return codedWord;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> FirstPart = new HashMap<Integer, String>();
		Map<Integer, String> SecondPart = new HashMap<Integer, String>();
		char[] array1 = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm' };
		char[] array2 = { 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < array1.length; i++) {
			FirstPart.put(new Integer(i), String.valueOf(array1[i]));
			SecondPart.put(new Integer(i), String.valueOf(array2[i]));
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Print a word needed to be coded and press Enter: ");
			String string = br.readLine();
			
			String coded = CodedWord(string, FirstPart, SecondPart);
			System.out.println("CodedWord: " + coded);

			String uncoded = CodedWord(coded, FirstPart, SecondPart);
			System.out.println("UnodedWord: " + uncoded);

		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
