import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hexdecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Print a hexdecimal value of an Integer and press Enter: ");
			String hex = br.readLine();
			int value = Integer.parseInt(hex, 16);
			System.out.println("Integer: " + value);
		} catch (IOException | NumberFormatException e) {
			System.out.println("ошибка ввода: " + e);
		}
	}

}
