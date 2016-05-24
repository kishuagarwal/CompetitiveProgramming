import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class InfinitePancakesBad {

	static ArrayList<Integer> pancakes = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("in.in"));
		PrintWriter writer = new PrintWriter("out2.out");
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			pancakes.clear();
			for (int j = 0; j < n; j++)
				pancakes.add(in.nextInt());
				
			writer.println("Case #"+i+": " + solve(0));
	}
		in.close();
		writer.close();

	}
	
	private static int solve(int value) {
		Pair p = greatest();
		int greatest = p.value;
		if (greatest <= 1) return value + greatest;
		int pass,special = 0;
		for(int i = 0; i < pancakes.size(); i++) {
			pancakes.set(i, pancakes.get(i) - 1);
		}
		pass = solve(value + 1);
		for(int i = 0; i < pancakes.size(); i++) {
			pancakes.set(i, pancakes.get(i) + 1);
		}
		pancakes.set(p.pos, greatest/2);
		pancakes.add(greatest - greatest/2);
		special = solve(value+1);
		pancakes.set(p.pos, greatest);
		pancakes.remove(pancakes.size()-1);
		return Math.min(pass, special);
	}
	
	private static Pair greatest() {
		int greatest = pancakes.get(0);
		int pos = 0;
		for (int i = 1; i < pancakes.size() ; i++) {
			if (pancakes.get(i) > greatest) {
				greatest = pancakes.get(i);
				pos = i;
			}
		}
		Pair p = new Pair();
		p.pos = pos;
		p.value = Math.max(0, greatest);
		return p;
	}

	static class Pair {
		Integer pos;
		Integer value;
	}
}
