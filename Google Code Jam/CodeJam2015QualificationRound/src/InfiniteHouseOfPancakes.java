import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class InfiniteHouseOfPancakes {

	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(new File("in.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter writer = new PrintWriter("out.out");
		int t = in.nextInt();
		int originalTimeRequired,currentTimeElapsed,currentTimeRequired=0,temp1;
		PriorityQueue<Integer> queue = new PriorityQueue<>(1,
				new Comparator<Integer>() {

					@Override
					public int compare(Integer ths, Integer that) {
						if (ths < that)
							return 1;
						if (ths > that)
							return -1;
						return 0;
					}
		});
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			queue.clear();
			int temp;
			for (int j = 0; j < n; j++) {
				temp = in.nextInt();
				//writer.print(temp + " ");
				queue.add(temp);
			}
			//writer.println();
			originalTimeRequired = queue.peek();
			currentTimeElapsed = 0;
			currentTimeRequired = 0;
			while(!queue.isEmpty()) {
				System.out.println(queue.toString());
				currentTimeElapsed += 1;
				temp = originalTimeRequired;
				temp1 = queue.poll();
				if (temp1 <= 3) break;
				queue.add(temp1 >> 1);
				queue.add(temp1 - (temp1 >> 1));
				currentTimeRequired = currentTimeElapsed + queue.peek();
				if (currentTimeRequired < originalTimeRequired)
					originalTimeRequired = currentTimeRequired;
				
			}
			writer.println("Case #"+i+": "+ originalTimeRequired);
		}
		in.close();
		writer.close();
	}

}
