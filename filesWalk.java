import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class filesWalk {
	public static boolean checkWords(Path filename) {
		String word1 = "volatile";
		String word2 = "transient";
		boolean vol = false;
		boolean trans = false;
		try {
			File f = new File(String.valueOf(filename));
			FileReader is = new FileReader(f);
			BufferedReader br = new BufferedReader(is);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.toLowerCase().contains(word1.toLowerCase()))
					vol = true;
				if (line.toLowerCase().contains(word2.toLowerCase()))
					trans = true;
				if (vol && trans)
					return true;
			}

		} catch (IOException e) {
			System.out.println("Error of path " + e);
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Files.walk(Paths.get("srczip/")).filter(p -> p.toString().endsWith(".java")).filter((p) -> checkWords(p)).forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("Error of path " + e);
		}

	}

}
