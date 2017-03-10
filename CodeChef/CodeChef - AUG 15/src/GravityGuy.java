import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GravityGuy {

	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		char l1[],l2[];
		int first = 0,second = 0, temp,temp2;
		boolean possible,l1usable,l2usable;
		while (t > 0) {
			t--;
			l1 = reader.readLine().toCharArray();
			l2 = reader.readLine().toCharArray();
			possible = true;
			first = 0; 
			second = 0;
			l1usable = true;
			l2usable = true;
			if (l1[0] == '#' ) l1usable = false;
			if (l2[0] == '#') l2usable = false;
			if (!l1usable && !l2usable) 
				possible = false;
			for (int i = 1; i < l1.length; i++) {
				if (l1[i] == '#' && l2[i] == '#') {
					possible = false;
					break;
				}
				if (l1usable) {
					if (l2usable)
						temp = Math.min(first, second + 1);
					else
						temp = first;
				}
				else 
					temp = second + 1;
				
				if (l2usable) {
					if (l1usable)
						temp2 = Math.min(second, first + 1);
					else
						temp2 = second;
				}
				else
					temp2 = first + 1;
				
				first = temp;
				second = temp2;
				l1usable = l1[i] == '.';
				l2usable = l2[i] == '.';
				
			}
			if (!possible) 
				System.out.println("No");
			else
			{
				System.out.println("Yes");
				if (l1usable && l2usable)
					System.out.println(Math.min(first, second));
				else
					if(l1usable)
						System.out.println(first);
					else
						System.out.println(second);
			}
		}
		reader.close();
	}

}
