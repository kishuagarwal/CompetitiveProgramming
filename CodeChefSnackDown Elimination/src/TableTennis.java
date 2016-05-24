import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TableTennis {

	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		String line;
		int temp,chefPoints,otherPoints;
		boolean tenReached,chefWon;
		for (int i = 1; i <= t; i++) {
			line = reader.readLine();
			chefPoints = 0;
			otherPoints = 0;
			tenReached = false;
			chefWon = false;
			for (int j = 0; j < line.length(); j++) {
				temp = line.charAt(j) - '0';
				if (temp == 1) chefPoints++;
				else otherPoints++;
				if (!tenReached && chefPoints == 10 && otherPoints == 10) {
					tenReached = true;
				}
				if (!tenReached && chefPoints == 11) {
					chefWon = true;
				}
				if (tenReached && Math.abs(chefPoints - otherPoints) == 2) {
					if (chefPoints > otherPoints) chefWon = true;
				}
			} 
			if (chefWon)
			System.out.println("WIN");
			else
				System.out.println("LOSE");
			}
		reader.close();

	}

}
