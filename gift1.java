/*
ID: name
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;

public class gift1 {

	public static void main(String[] args) throws IOException {
		BufferedReader b1 = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter pw = new PrintWriter(new File("gift1.out"));
		StringTokenizer st = new StringTokenizer(b1.readLine());
		LinkedHashMap<String, Integer> h1 = new LinkedHashMap<String, Integer>();
		int length = Integer.parseInt(st.nextToken());
		for (int a = 0; a < length; a++) {
			h1.put(b1.readLine(), 0);
		}
		String line = "";
		int moneyOut = 0;
		int givenTo = 0;
		String[] tempNames;
		String currentName;
		int remainder;
		int amountOfMoneyGiven;
		while ((line = b1.readLine()) != null) {
			remainder = 0;
			amountOfMoneyGiven = 0;
			currentName = line;
			st = new StringTokenizer(b1.readLine());
			moneyOut = Integer.parseInt(st.nextToken());
			givenTo = Integer.parseInt(st.nextToken());
			tempNames = new String[givenTo];
			h1.replace(currentName, h1.get(currentName) - moneyOut);
			for (int i = 0; i < givenTo; i++) {
				tempNames[i] = b1.readLine();
			}
			if (givenTo != 0) {
				remainder = moneyOut % givenTo;
				amountOfMoneyGiven = moneyOut / givenTo;
			}
			for (int j = 0; j < givenTo; j++) {
				h1.replace(tempNames[j], h1.get(tempNames[j]) + amountOfMoneyGiven);
			}
			h1.replace(currentName, h1.get(currentName) + remainder);
		}
		for (String i : h1.keySet()) {
			pw.println(i + " " + h1.get(i));
		}
		pw.close();
		b1.close();
	}

}
