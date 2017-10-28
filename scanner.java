import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class scanner {
	public static Stream<String> scannerToWords(Scanner scanner) 
	{
		System.out.println("Enter something, 'q' to quit");
		Iterator<String> It = new Iterator<String>() {
			String word;
			public boolean hasNext(){
				if ("q".equalsIgnoreCase(word))
					return false;
				else
					return scanner.hasNext();
			}
			
			public String next(){
				word = scanner.next();
				return word;
			}
		};
		
		Iterable<String> iterable = ()-> It;
		Spliterator<String> spliterator = iterable.spliterator();
		return StreamSupport.stream(spliterator,false);
	}
	

	public static Stream<String> scannerToLines(Scanner scanner) {
		System.out.println("Enter something, and 'quit' to exit");		
		Iterator<String> It = new Iterator<String>() {
			String line;
			public boolean hasNext(){
				if ("quit".equalsIgnoreCase(line))
					return false;
				else
					return scanner.hasNextLine();
			}
			
			public String next(){
				line = scanner.nextLine();
				return line;
			}
		};
		
		Iterable<String> iterable = ()-> It;
		Spliterator<String> spliterator = iterable.spliterator();
		return StreamSupport.stream(spliterator,false);
	}

	public static Stream<Integer> scannerToIntegers(Scanner scanner) {
		System.out.println("Enter some integers, and something not integer to quit");
		
		Iterator<Integer> It = new Iterator<Integer>() {
			int number;
			public boolean hasNext(){
				return scanner.hasNextInt();
			}
			
			public Integer next(){
				number = scanner.nextInt();
				return number;
			}
		};
		
		Iterable<Integer> iterable = ()-> It;
		Spliterator<Integer> spliterator = iterable.spliterator();
		return StreamSupport.stream(spliterator,false);
	}

	public static Stream<Double> scannerToDoubles(Scanner scanner) {
		System.out.println("Enter some doubles, and something not doubles to quit");
		
		Iterator<Double> It = new Iterator<Double>() {
			double number;
			public boolean hasNext(){
				return scanner.hasNextDouble();
			}
			
			public Double next(){
				number = scanner.nextDouble();
				return number;
			}
		};
		Iterable<Double> iterable = ()-> It;
		Spliterator<Double> spliterator = iterable.spliterator();
		return StreamSupport.stream(spliterator,false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Stream<Integer> stream = scannerToIntegers(scanner);
		//Stream<String> stream = scannerToWords(scanner);
		//Stream<String> stream = scannerToLines(scanner);
		//Stream<Double> stream = scannerToDoubles(scanner);
		stream.forEach(s -> System.out.println(s));
	}

}
