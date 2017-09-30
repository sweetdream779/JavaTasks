import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	public static Supplier<Stream<String>> zip(Supplier<Stream<Integer>> first, Supplier<Stream<Character>> second) {
		Supplier<Stream<String>> newStream;
		long n;
		List<String> myList = new ArrayList<String>();

		if (first.get().count() < second.get().count())
			n = first.get().count();
		else
			n = second.get().count();
		for (long i = 0; i < n; i++) {
			myList.add(Integer.toString(first.get().skip(i).findFirst().get()));
			myList.add(String.valueOf(second.get().skip(i).findFirst().get()));
		}
		newStream = () -> myList.stream();
		return newStream;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Supplier<Stream<Integer>> integers = () -> IntStream.range(0, 100).boxed();

		String line = "abcdefghijklmnopqrstuvwxyz";
		Supplier<Stream<Character>> letters = () -> Stream.of(line.chars().mapToObj(c -> (char) c).toArray(Character[]::new));

		Supplier<Stream<String>> zipStream = zip(integers, letters);
		zipStream.get().forEach(x -> System.out.println(x));
	}

}
