import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class MouseJerry {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int  t = in.nextInt();
		int n,sx,sy,ex,ey,bx,by;
		int matrix[][];
		
		for (int i = 1; i<= t;i++) {
			 	n =in.nextInt();
			 	sx = in.nextInt();
			 	sy = in.nextInt();
			 	ex = in.nextInt();
			 	ey = in.nextInt();
			 	bx = in.nextInt();
			 	by = in.nextInt();
			 	matrix = new int[n][n];
			 	
			 	matrix[sx-1][sy-1] = 0;
			 	
			 	Queue<Point> queue = new ArrayDeque<>();
			 	Point start = new Point();
			 	start.x = sx-1;
			 	start.y = sy-1;
			 	queue.add(start);
			 	matrix[bx-1][by-1] = -3;
			 	
			 	while (!queue.isEmpty()) {
			 		Point p = queue.poll();
					int dx[] = {-1,0,1,0};
					int dy[] = {0,1,0,-1};
					int nx,ny;
					for (int j = 0; j < 4; j++) {
						nx = p.x + dx[j];
						ny = p.y + dy[j];
						if (nx >= 0 && nx < n && ny >=0 && ny < n) {
							if (matrix[nx][ny] == 0) {
								matrix[nx][ny] = matrix[p.x][p.y] + 1;
								Point px = new Point();
								px.x = nx;
								px.y = ny;
								queue.add(px);
							}
							
						}
					}

			 	}
			 	System.out.println(matrix[ex-1][ey-1]);
		} 
		in.close();
	}
	
	
	static class Point {
		int x;
		int y;
	}

}
