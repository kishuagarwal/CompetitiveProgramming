import java.util.PriorityQueue;
import java.util.Scanner;

public class SenateEvacuation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 1 ; i <= t ; i++ ){
			int n = in.nextInt();
			PriorityQueue<Party> queue = new PriorityQueue<>();
			int total = 0;
			System.out.print("Case #"+i+": ");
			for (int j = 0 ; j < n; j++) {
				int temp = in.nextInt();
			//	System.out.print(temp + " ");
				queue.add(new Party(j, temp));
				total += temp;
			}
			//System.out.println();
			while (!queue.isEmpty()) {
				Party top = queue.poll();
				if (queue.isEmpty()) {
					if (top.count == 1)
					System.out.print((top.c+""));
					else
						System.out.print((top.c + "") + (top.c + ""));
					break;
				}
				Party second = queue.peek();
				//is it favourable for second
				if (top.count -2 >= 0 && !(second.count > ((total - 2)/2))) {
					System.out.print((top.c+"") + (top.c + "") + " ");
					top.count -= 2;
					total -=2;
					if (top.count != 0)
					queue.add(top);
				}
				else {
					//if (top.count - 1 >= 0 && !(second.count > (total - 1) / 2) ) {
					System.out.print((top.c + "") + (second.c + "") + " " );
					second = queue.poll();
					top.count -= 1;
					second.count -= 1;
					total -= 2;
					if (top.count != 0)
					queue.add(top);
					if (second.count != 0)
					queue.add(second);
				}
//				else {
//					System.out.print((char)top.c+ " ");
//					top.count -= 1;
//					total -= 1;
//					queue.add(top);
//				}
			}
			System.out.println();
				
		}
		
		in.close();
		

	}
	
	static class Party implements Comparable<Party> {
		char c;
		int count;
		public Party(int i , int count) {
			this.c = (char) ('A' + i);
			this.count = count;
		}
		@Override
		public int compareTo(Party o) {
			return o.count - this.count;
		}
		
		
	}

}
