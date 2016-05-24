import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class MinesweeperMaster {

	/**
	 * @param args
	 */
	static char[][] matrix ;
	static int neighboursdx[] = {0,-1,-1,-1,0,1,1,1};
	static int neighboursdy[] = {-1,-1,0,1,1,1,0,-1};
	static int r,c;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.in"));
		PrintWriter write = new PrintWriter(new File("output.out"));
		int t = in.nextInt();
		int m,j,k,x,y,nx,ny;
		int dx[] = {0,1,0,-1};
		int dy[] ={1,0,-1,0};
		int direction;
		for(int i = 1; i <= t;i++){
			r = in.nextInt();
			c = in.nextInt();
			m = in.nextInt();
			matrix = new char[r][c];
			direction = 0;
			x = y = 0;
			for(j = 0; j < r;j++)
				for(k = 0; k < c;k++)
					matrix[j][k] = '.';
			while(m > 0){
				m--;
				matrix[x][y] = '*';
				nx = x + dx[direction];
				ny = y + dy[direction];
				if(!isValid(nx,ny) || matrix[nx][ny] == '*'){
					direction = (direction+1)%4;
					x = x+dx[direction];
					y = y+dy[direction];
				}	
				else
				{
					x = nx;
					y = ny; 
				}
			}
			write.println("Case #"+i+": ");
			if(emptyCellAvailabe()){
				for(int s = 0; s < r; s++){
					for(int p = 0 ; p<c;p++){
						if(matrix[s][p] == '1' || matrix[s][p] == '0')
							matrix[s][p] = '.';
					}
				}
				for(j = 0; j < r;j++){
					for(k = 0; k < c;k++)
					{
						write.print(matrix[j][k]);
						}
					write.println();
				}
			}
			else
				write.println("Impossible");
		}
		in.close();
		write.close();
	}
	private static boolean emptyCellAvailabe() {
		// TODO Auto-generated method stub
		for(int i = 0; i <r ;i++){
			for(int j = 0; j < c;j++){
				if(matrix[i][j] =='*')
					continue;
				else
				{
					if(!minesNear(i, j))
					{
						for(int s = 0; s < r; s++){
							for(int p = 0 ; p<c;p++){
								if(matrix[s][p] == '1' || matrix[s][p] == '0')
									matrix[s][p] = '.';
							}
						}
						if(canBefilled(i,j)){
						matrix[i][j] = 'c';
						return true;
						}
						else
							return false;
					}
				}
			}
		}
		return false;
		
		
		
	}
	
	private static boolean canBefilled(int i, int j){
		fill(i,j);
		for(int x = 0; x <r ;x++){
			for(int y = 0; y < c; y++){
			System.out.print(matrix[x][y]);
			}
			System.out.println();
			
		}
		
		for(int x = 0; x <r ;x++){
			for(int y = 0; y < c; y++){
				if(matrix[x][y] == '.')
					return false;
			}
		}
		
		return true;
	}
	private static void fill(int i,int j){
		int k;
		int x,y;
		if(minesNear(i,j))
		matrix[i][j] = '1';
		else
		{
			matrix[i][j] = '0';
		for(k = 0; k < 8;k++){
			x = i + neighboursdx[k];
			y = j + neighboursdy[k];
			if(isValid(x,y) && matrix[x][y] == '.')
				fill(x,y);
		}
		}
	}
	private static boolean minesNear(int i,int j){
		int k,x,y;
		for(k = 0; k < 8;k++){
			x = i + neighboursdx[k];
			y = j + neighboursdy[k];
			if(isValid(x,y) && matrix[x][y] == '*')
				return true;
		}
		return false;
	}
	private static boolean isValid(int x,int y){
		if(x < 0 || x >= r || y < 0 || y >= c )
			return false;
		else
			return true;
	}

}
