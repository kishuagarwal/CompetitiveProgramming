import java.util.Arrays;
import java.util.Scanner;


public class PizzaDelivaryService {

	static Node sortedList[];
	static int x;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n;
		int	totalOrder;
		int max,min;
		sortedList = new Node[500];
		for (int i = 0; i < t; i++) {
			x = in.nextInt();
			n = in.nextInt();
			totalOrder = 0;
			for (int j = 0; j < x; j++) {
				Node node = new Node();
				sortedList[j] = node;
				sortedList[j].pizzasCount= in.nextInt();
			}
			for (int j = 0; j < x; j++) {
				sortedList[j].cost = in.nextInt();
			}
			Arrays.sort(sortedList,0,x);
			
			for (int j = 0; j < n; j++) {
				totalOrder += in.nextInt();
			}
			 min = findmin(totalOrder, x-1);
			max = findmax(totalOrder,0);
			
			System.out.println(max-min);
		}
		in.close();
	}
	
	public static int findmin(int pizzas, int pos){
		
		if(pos == 0){
		int order = (int) Math.ceil((double)pizzas/sortedList[pos].pizzasCount);
		int price = order*sortedList[pos].cost;
		return price;
		}
		int order = pizzas/sortedList[pos].pizzasCount;
		int price = order*sortedList[pos].cost;
		int left= (pizzas - order*sortedList[pos].pizzasCount); 
		if( left > 0){
		price +=Math.min(sortedList[pos].cost, findmin(left,pos-1));
		}
		return price;
	
	}
	
public static int findmax(int pizzas, int pos){
		
		if(pos == (x-1)){
		int order = (int) Math.ceil((double)pizzas/sortedList[pos].pizzasCount);
		int price = order*sortedList[pos].cost;
		return price;
		}
		int order = pizzas/sortedList[pos].pizzasCount;
		int price = order*sortedList[pos].cost;
		int left= (pizzas - order*sortedList[pos].pizzasCount); 
		if( left > 0){
			
		price +=Math.max(sortedList[pos].cost, findmin(left,pos+1));
		}
		return price;
	
	}
	static class Node implements Comparable<Node>{

		int cost;
		int pizzasCount;
		@Override
		public int compareTo(Node n) {
			// TODO Auto-generated method stub
			double thisprice = (double)pizzasCount/cost;
			double thatprice = (double)n.pizzasCount/n.cost;
			if(thisprice == thatprice)
				{
				if(pizzasCount > n.pizzasCount)
					return -1;
				else
					return 0;
				}
			if(thisprice < thatprice)
				return -1;
			return 1;
		}
		
	}

}
