import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class letterCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		char symbol;
		String string = null;
		try {
			System.out.println("Print a char needed to be counted in text file and press Enter: ");
			string = b.readLine();
			if (string.length() != 1) {
				System.out.println("You must print EXACTLY one symbol.");
				System.exit(1);
			}
		} catch (IOException e) {
			System.out.println("ошибка ввода" + e);
		}
		symbol = Character.toLowerCase(string.toCharArray()[0]);
		try {
			File f = new File("t.txt");
			FileReader is = new FileReader(f);
			BufferedReader br = new BufferedReader(is);
			String line = null;
			char[] letters;
			int count = 0;
			while ((line = br.readLine()) != null) {
				letters = line.toCharArray();
				for (char letter : letters)
					if (Character.toLowerCase(letter) == symbol)
						count++;
			}
			is.close();
			br.close();
			System.out.println("Symbol '" + symbol + "' appears in the text " + String.valueOf(count) + " times.");

		} catch (IOException e) {
			System.out.println("ошибка файла: " + e);
		}
	}

}
