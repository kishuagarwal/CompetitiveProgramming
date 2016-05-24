import java.util.Scanner;


public class TraceTheRats {

	static int n;
	static char maze[][] ;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int r;
		n = in.nextInt();
		maze = new char[n][n];
		for(int i = 0; i < n;i++){
				String input = in.next();
				maze[i] = input.toCharArray();
				
		}
		r = in.nextInt();
		int ratPos[][] = new int[2][r];
		for(int i = 0; i< r;i++){
			ratPos[0][i] = in.nextInt()-1;
			ratPos[1][i] = in.nextInt()-1;
		}
		if(maze[ratPos[0][0]][ratPos[1][0]] != 'X')
		dfs(ratPos[0][0],ratPos[1][0]);
		boolean isPossible = true;
		for(int i = 0; i< r;i++){
			if(maze[ratPos[0][i]][ratPos[1][i]] != 'V'){
				isPossible = false;
				break;
			}
		}
		if(isPossible)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		
		in.close();
		
	}
	
	public static void dfs(int x,int y){
		int nx, ny;
		
		for(int k = 0; k < 4; k++){
			nx = x + dx[k];
			ny = y + dy[k];
			if(nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1))
				continue;  //not a valid position
			if(maze[nx][ny] != 'X' )
				maze[nx][ny]
		}
	}

}
