import java.math.BigInteger;
import java.util.stream.Stream;

public class randomValues {

	public static Stream<BigInteger> random(int seed, long a, int c, long m) {
		Stream<BigInteger> streamFromIterate = Stream.iterate(BigInteger.valueOf(seed), k -> BigInteger.valueOf((k.longValue() + c) % m));
		return streamFromIterate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int seed = 20;
		long a = 25214903917L;
		int c = 11;
		long m = 2 ^ 48L;
		Stream<BigInteger> streamFromIterate = random(seed, a, c, m);
		streamFromIterate.forEach(x -> System.out.println(x));

	}

}
