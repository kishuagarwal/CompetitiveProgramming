import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DevuAndPerfume {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		String[] input;
		int map[][];
		int top,bottom,left,right;
		for (int i = 0; i < t; i++) {
			int n,m;
			input = reader.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			map = new int[n][m];
			for (int j = 0; j < n; j++) {
				String row = reader.readLine();
				for (int k = 0; k < m; k++) {
					map[j][k] = row.charAt(k)  == '*' ? 1 : 0; 
				}
			}
			top = 0;
			int index;
			while (top < n) {
				index = 0;
				while (index < m && map[top][index] == 0) {
					index++;
				}
				if (index < m) break;
				top++;
					
			}
			bottom = n-1;
			while (bottom >= 0) {
				index = 0;
				while (index < m && map[bottom][index] == 0) {
					index++;
				}
				if (index < m) break;
				bottom--;
					
			}
			left = 0;
			while (left < m) {
				index = 0;
				while (index < n && map[index][left] == 0) {
					index++;
				}
				if (index < n) break;
				left++;
					
			}
			right = m-1;
			
			while (right >= 0) {
				index = 0;
				while (index < n && map[index][right] == 0) {
					index++;
				}
				if (index < n) break;
				right--;
					
			}
			if(top == n) //nothing
				System.out.println(0);
			else
			if (top == bottom && left == right ) //only one house
				System.out.println(1);
			else
				System.out.println(Math.max((bottom-top + 1) / 2, (right - left + 1) / 2) + 1);
			//System.out.println(top + "  " + bottom + "  " + left + "  " + right);
		}
		reader.close();
	}

}
