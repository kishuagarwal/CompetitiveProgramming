import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class TheTalkativeFrogs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n,k,p;
		n = in.nextInt();
		k = in.nextInt();
		p = in.nextInt();
		int pos[] = new int[n];
		ArrayList<Node> list = new ArrayList<Node>(); 
		for(int i =0; i < n; i++ )
		{
			pos[i] = in.nextInt();
			Node node =new Node(); 
			node.pos = pos[i];
			node.number = i;
			list.add(node);
		}
		Collections.sort(list, new NodeComparator());
		int currentComponent = 0;
		int lastPos = list.get(0).pos; 
		for(Node node:list){
			if(node.pos > (lastPos+k))
			currentComponent++;
			pos[node.number] = currentComponent; 
			lastPos = node.pos;
		}
		int first,second;
		for(int i = 0; i < p ;i++)
		{
			first = in.nextInt();
			second = in.nextInt();
			if(pos[first-1] == pos[second-1])
				System.out.println("Yes");
			else
				System.out.println("No"); 
		}
		in.close();
	}
		

	
	
	}
class Node {
	int pos;
	int number;
}

class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node n1, Node n2) {
		// TODO Auto-generated method stub
		if(n1.pos <= n2.pos)
			return -1;
		else
			return 1;
	}
	
}
