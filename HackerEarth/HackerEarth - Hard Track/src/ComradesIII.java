import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ComradesIII {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		int order[] = new int[N];
		int position[] = new int[N];
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			order[i] = Integer.parseInt(tokenizer.nextToken());
		}
		int pos = -1;
		LinkedList<Integer> sort = new LinkedList<Integer>();
		while (true) {
			System.out.println(sort.toString());
			LinkedList<Integer> temp = new LinkedList<Integer>();
			// find the first non seen supervisor
			while (++pos < N && order[pos] == -1)
				continue;
			if (pos == N)
				break;
			while (order[pos] != 0 && order[pos] != -1) {
				temp.add(pos);
				int backup = order[pos] -1;
				order[pos] = -1;
				pos = backup;
			}
			if (order[pos] == 0) {
				temp.add(pos);
				order[pos] = -1;
			}
			sort.addAll(0, temp);
		}
		
		pos = 0;
		for (Integer i : sort) {
			position[i] = pos++;
		}
		System.out.println(Arrays.toString(position));
		int q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < q; i++) {
			line = br.readLine();
			tokenizer = new StringTokenizer(line);
			switch (Integer.parseInt(tokenizer.nextToken())) {
			case 1:
				
				break;

			case 2:
				break;

			case 3:
				break;
			}
		}
	}
}
