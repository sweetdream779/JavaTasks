import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Hexdecimal {
	
	static long hexToDecimal(String string){
		String h=string.toUpperCase();
		char[] hex = h.toCharArray();
		int ascii, value,j;
		j=hex.length;
		long result=0;
		value=0;
		for (char letter : hex) {
			j--;
			ascii=(int)letter;
			if(ascii>47&&ascii<58)
				value = Character.getNumericValue(letter);
			else if(ascii>64&&ascii<71)
				value =ascii-55;
			else
				return -1;
			result+=(long)value*Math.pow(16, j);
			System.out.println(String.valueOf(value)+" "+String.valueOf(j)+" "+result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Print a hexdecimal value of an Integer and press Enter: ");
			String hex = br.readLine();
			long value = hexToDecimal(hex);
			if (value==-1)
				System.out.println("There is not convertable symbol");
			else
				System.out.println("Integer: " + String.valueOf(value));
		} catch (IOException | NumberFormatException e) {
			System.out.println(e);
		}
	}

}
