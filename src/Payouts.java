import java.util.ArrayList;
import java.util.Arrays;

public class Payouts {

	/*
	 * public static void main(String[] args) { int[] markers = {0, 154, 256,
	 * 364, 456, 551, 665, 750, 862, 960}; ArrayList<Integer> original =
	 * readFile(); System.out.println((original.size() * 25 -
	 * getPayouts(markers, original))); }
	 */
	public static int getPayouts(int[] markers, ArrayList<Integer> original) {
		Arrays.sort(markers);
		int payouts = 0;
		for (int integer : original) {
			int diff = diff(integer, markers[0]);
			int smallest = diff;
			for (int i = 0; i < markers.length; i++) {
				diff = diff(integer, markers[i]);
				if (smallest > diff)
					smallest = diff;
			}
			payouts += smallest;
		}
		return payouts;
	}

	public static ArrayList<Integer> readFile(String filepath) {
		ArrayList<String> numbersRAW = readFileRaw(filepath);
		return wandelUm(numbersRAW);
	}

	public static ArrayList<String> readFileRaw(String filepath) {

		// a new line equals a new word
		ArrayList<String> numbersRAW = new ArrayList<>();
		java.io.LineNumberReader reader;
		String line;
		try {
			reader = new java.io.LineNumberReader(new java.io.FileReader(filepath));
			while ((line = reader.readLine()) != null) {
				numbersRAW.add(line);
			}
			reader.close();
		} catch (java.io.IOException e) {
			System.err.println(e.toString());
		}
		return numbersRAW;
	}

	private static ArrayList<Integer> wandelUm(ArrayList<String> numbersRAW) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < numbersRAW.size(); i++) {
			try {
				numbers.add(Integer.parseInt(numbersRAW.get(i)));
			} catch (java.lang.NumberFormatException e) {
				System.out.println(numbersRAW.get(i) + " ist kein Gültiger wert und wird nicht gewertet!");
			}
		}
		return numbers;
	}

	public static int diff(int a, int b) {
		if (a - b > 0)
			return a - b;
		if (b - a > 0)
			return b - a;
		return 0;
	}
}
