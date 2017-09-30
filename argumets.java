import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class argumets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long len;
		int linesNumb;
		int randomInt;
		String filepath;
		Integer lineNumber;
		File f;
		FileReader is;
		BufferedReader br;
		String line = null;
		try {
			filepath = args[0];
			lineNumber = Integer.valueOf(args[1]);

			f = new File(filepath);
			is = new FileReader(f);
			br = new BufferedReader(is);

			len = f.length();
			linesNumb = new Double(Math.ceil(len / 64)).intValue();
			// System.out.println(len);

			List<String> list = new ArrayList<String>(linesNumb);
			while ((line = br.readLine()) != null) {
				list.add(line);
			}

			Random randomGenerator = new Random();
			for (int i = 0; i < lineNumber; i++) {
				randomInt = randomGenerator.nextInt(linesNumb - 1);
				System.out.println(randomInt + 1 + " line: " + list.get(randomInt));
			}
			is.close();
			br.close();

		} catch (IOException | NumberFormatException e) {
			System.out.println("ошибка файла: " + e);
		}

	}

}
