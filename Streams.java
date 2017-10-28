import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Iterator;
import java.util.Spliterator;

public class Streams {	
	public static Stream<String> zip(Stream<Integer> first, Stream<Character> second){
	Iterator<Integer> firstIt = first.iterator();
	Iterator<Character> secondIt = second.iterator();
	Iterator<String> It = new Iterator<String>() {
		boolean isFirst = true;
		public boolean hasNext(){
			if(isFirst) return firstIt.hasNext();
			return secondIt.hasNext();
		}
		public String next(){
			if (isFirst){
				isFirst = false;
				return String.valueOf(firstIt.next());
			}
			isFirst = true;
			return String.valueOf(secondIt.next());
		}
	};
	Iterable<String> iterable = ()-> It;
	Spliterator<String> spliterator = iterable.spliterator();
	return StreamSupport.stream(spliterator, false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Integer> integers = IntStream.range(0, 100).boxed();

		String line = "abcdefghijklmnopqrstuvwxyz";
		Stream<Character> letters = Stream.of(line.chars().mapToObj(c -> (char) c).toArray(Character[]::new));

		Stream<String> zipStream = zip(integers, letters);
		zipStream.forEach(x -> System.out.println(x));
	}

}
