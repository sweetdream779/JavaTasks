import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Euclid {

	static int method1(int a, int b) {
		if (b == 0)
			return a < 0 ? -a : a;
		return method1(b, a % b);
	}

	static int method2(int a, int b) {
		if (b == 0)
			return a < 0 ? -a : a;

		return method2(b, Math.floorMod(a, b));
	}

	static int rem(int a, int b) {
		int remainder = 0;
		if (b == 0)
			return a < 0 ? -a : a;
		if (a == 0)
			return rem(b, a);
		if ((a > 0 && b > 0) || (a < 0 && b > 0)) {
			remainder = a - ((int) Math.floor(a / b)) * b;
		}
		if (a > 0 && b < 0) {
			remainder = a - (int) (Math.ceil(a / b)) * b;
		}

		return rem(b, remainder);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Введите целые числа через пробел и нажмите Enter: ");
			String h = br.readLine();
			String[] splited = h.split("\\s+");

			if (splited.length != 2) {
				System.out.println("Вы ввели не 2 числа");
				System.exit(1);
			}

			a = Integer.valueOf(splited[0]).intValue();
			b = Integer.valueOf(splited[1]).intValue();

			System.out.println("НОД числе с помощью %: " + method1(a, b));
			System.out.println("НОД числе с помощью floorMod: " + method2(a, b));
			System.out.println("НОД числе с помощью rem: " + rem(a, b));

		} catch (IOException | NumberFormatException e) {
			System.out.println("ошибка ввода" + e);
		}
	}

}
