import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class scanner {
	public static Stream<String> scannerToWords(Scanner scanner) {
		System.out.println("Enter something, 'q' to quit");
		List<String> myList = new ArrayList<String>();
		String word;
		while (scanner.hasNext()) {
			word = scanner.next();
			if ("q".equalsIgnoreCase(word))
				break;
			myList.add(word);
		}
		return myList.stream();
	}

	public static Stream<String> scannerToLines(Scanner scanner) {
		// final Spliterator<String> splt = Spliterators.spliterator(scanner,
		// Long.MAX_VALUE, Spliterator.ORDERED | Spliterator.NONNULL);
		// return StreamSupport.stream(splt, false).onClose(scanner::close);
		System.out.println("Enter something, and 'quit' to exit");
		List<String> myList = new ArrayList<String>();
		String line;
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if ("quit".equalsIgnoreCase(line))
				break;
			myList.add(line);
		}
		return myList.stream();
	}

	public static Stream<Integer> scannerToIntegers(Scanner scanner) {
		System.out.println("Enter some integers, and something not integer to quit");
		List<Integer> myList = new ArrayList<Integer>();
		int number;
		while (scanner.hasNextInt()) {
			number = scanner.nextInt();
			myList.add(number);
		}
		return myList.stream();
	}

	public static Stream<Double> scannerToDoubles(Scanner scanner) {
		System.out.println("Enter some doubles, 'q' to quit");
		List<Double> myList = new ArrayList<Double>();
		double number;
		String next;
		while (scanner.hasNext()) {
			try {
				next = scanner.next();
				if ("q".equalsIgnoreCase(next))
					break;
				number = Double.parseDouble(next);
				myList.add(number);
			} catch (NumberFormatException e) {
				System.out.println("Value not double: " + e);
			}
		}
		return myList.stream();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		// Stream<Integer> stream = scannerToIntegers(scanner);
		// Stream<String> stream = scannerToWords(scanner);
		// Stream<String> stream = scannerToLines(scanner);
		Stream<Double> stream = scannerToDoubles(scanner);
		stream.forEach(s -> System.out.println(s));
	}

}
